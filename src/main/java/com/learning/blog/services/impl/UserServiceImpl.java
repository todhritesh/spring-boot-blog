package com.learning.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.blog.entities.User;
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
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public boolean deleteUser(int userId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<UserDto> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDto getUserById(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
