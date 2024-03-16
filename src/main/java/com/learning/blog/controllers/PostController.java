package com.learning.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.learning.blog.payloads.ApiResponse;
import com.learning.blog.payloads.PostDto;
import com.learning.blog.services.PostService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<ApiResponse> createPost(@RequestBody @Valid PostDto postDto){
        PostDto post = this.postService.createPost(postDto,52,2);
        return new ResponseEntity<>(new ApiResponse("Post created successfully",true,post),HttpStatus.CREATED);
    }
    
}
