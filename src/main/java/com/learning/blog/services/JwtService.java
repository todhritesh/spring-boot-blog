package com.learning.blog.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {
    public String generateToken(UserDetails userDetails);

    public String extractUsername(String token);

    public boolean isTokenValid(String token, UserDetails userDetails);

    public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);


}
