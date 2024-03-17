package com.learning.blog.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MyUserDetailsService {
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public UserDetailsService userDetailsService();

}
