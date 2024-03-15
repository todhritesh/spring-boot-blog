package com.learning.blog.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.blog.entities.User;
import com.learning.blog.exceptions.ResourceNotFoundException;
import com.learning.blog.mapper.UserMapper;
import com.learning.blog.payloads.UserDto;
import com.learning.blog.repositories.UserRepository;
import com.learning.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = this.userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public boolean deleteUser(int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        this.userRepository.delete(user);
        return true;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            UserDto u = new UserDto(this.userMapper.toDto(user));
            System.out.println(u +"========check====");
            
            usersDto.add(u);
        }
        System.out.println("after for loop========"+usersDto);
         return usersDto;
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
        return this.userMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        User updatedUser = this.userRepository.save(user);
        return this.userMapper.toDto(updatedUser);
    }
    
}