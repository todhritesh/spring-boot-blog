package com.learning.blog.services;

import java.util.List;

import com.learning.blog.payloads.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto , int userId);
    UserDto getUserById(int userId);
    List<UserDto> getAllUsers();
    boolean deleteUser(int userId);
    UserDto getUserByEmail(String email);
}
