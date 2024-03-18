package com.learning.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.blog.entities.User;
import com.learning.blog.exceptions.ResourceNotFoundException;
import com.learning.blog.repositories.UserRepository;
import com.learning.blog.services.MyUserDetailsService;

@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     User user = this.userRepository.findByEmail(username)
    //             .orElseThrow(() -> new ResourceNotFoundException("user", "username " + username, 0));
    //     return this.modelMapper.map(user, UserDetails.class);
    // }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByEmail(username)
                        .orElseThrow(() -> new ResourceNotFoundException("user", "username " + username, 0));
                return user;
            }

        };
    }

}
