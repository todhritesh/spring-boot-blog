package com.learning.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.blog.entities.Category;
import com.learning.blog.entities.Post;
import com.learning.blog.entities.User;

public interface PostRepository extends JpaRepository<Post , Integer>{

    public List<Post> findByCategory(Category category);

    public List<User> findByUser(User user);
    
}
