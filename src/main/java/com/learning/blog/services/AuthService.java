package com.learning.blog.services;

import com.learning.blog.payloads.AuthDto;
import com.learning.blog.payloads.LoginDto;
import com.learning.blog.payloads.SignupDto;
import com.learning.blog.payloads.UserDto;

public interface AuthService {
    AuthDto login(LoginDto loginDto);

    UserDto signup(SignupDto signupDto);
}
