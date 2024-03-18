package com.learning.blog.services.impl;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.blog.entities.Role;
import com.learning.blog.entities.User;
import com.learning.blog.payloads.AuthDto;
import com.learning.blog.payloads.LoginDto;
import com.learning.blog.payloads.SignupDto;
import com.learning.blog.payloads.UserDto;
import com.learning.blog.services.AuthService;
import com.learning.blog.services.JwtService;
import com.learning.blog.services.UserService;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService ;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthDto login(LoginDto loginDto) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        UserDto userDto = userService.getUserByEmail(loginDto.getEmail());
        User user = this.modelMapper.map(userDto, User.class);
        String token = this.jwtService.generateToken(user);
        String refreshToken = this.jwtService.generateRefreshToken(new HashMap<>(), user);

        var authDto = new AuthDto();
        authDto.setRefreshToken(refreshToken);
        authDto.setToken(token);

        return authDto;
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        signupDto.setRole(Role.USER);
        signupDto.setPassword(this.passwordEncoder.encode(signupDto.getPassword()));
        var mappedUser =this.modelMapper.map(signupDto,UserDto.class);
        System.out.println("==========="+mappedUser+"===========");
        var user = this.userService.createUser(mappedUser);
        return this.modelMapper.map(user, UserDto.class);
    }
    
}
