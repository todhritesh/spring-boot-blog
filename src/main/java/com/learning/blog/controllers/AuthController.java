package com.learning.blog.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.blog.payloads.ApiResponse;
import com.learning.blog.payloads.LoginDto;
import com.learning.blog.payloads.SignupDto;
import com.learning.blog.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto){
        var authDto = this.authService.login(loginDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Login successful",true,authDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid SignupDto signupDto){
        try{
            var userDto = this.authService.signup(signupDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Signup successful",true,userDto));
        } catch(DataAccessException e){
            var myMap = new HashMap<String,String>();
            myMap.put("error", "Email already exist : "+signupDto.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Signup successful",true,myMap));
        }
    }

    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody @Valid SignupDto signupDto){
        
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Signup successful",true,"hello test"));
    }
    
}
