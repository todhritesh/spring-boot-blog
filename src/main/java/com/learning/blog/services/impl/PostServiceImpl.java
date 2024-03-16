package com.learning.blog.services.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.blog.entities.Post;
import com.learning.blog.payloads.CategoryDto;
import com.learning.blog.payloads.PostDto;
import com.learning.blog.payloads.UserDto;
import com.learning.blog.repositories.PostRepository;
import com.learning.blog.services.CategoryService;
import com.learning.blog.services.PostService;
import com.learning.blog.services.UserService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, int userId, int categoryId) {
        UserDto user = this.userService.getUserById(userId);
        CategoryDto category = this.categoryService.getCategoryById(categoryId);
        postDto.setCreatedAt((new Date(System.currentTimeMillis())));
        postDto.setUser(this.modelMapper.map(user, UserDto.class));
        postDto.setCategory(this.modelMapper.map(category, CategoryDto.class));
        System.out.println("============="+postDto+"==============");
        Post post = this.modelMapper.map(postDto, Post.class);
        Post savedPost = this.postRepository.save(post);
        return this.modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public void deletePost(PostDto postDto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public PostDto getAllPost() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostDto getAllPostByCategory(long categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostDto getAllPostByUser(long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostDto getPostById(long postId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
