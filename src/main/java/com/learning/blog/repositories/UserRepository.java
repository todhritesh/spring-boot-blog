package com.learning.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.blog.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

        
}
