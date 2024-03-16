package com.learning.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.blog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category , Long> {

    
    
}
