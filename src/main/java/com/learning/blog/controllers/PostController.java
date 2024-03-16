package com.learning.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.learning.blog.payloads.ApiResponse;
import com.learning.blog.payloads.PostDto;
import com.learning.blog.services.PostService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> updatePost(@RequestBody @Valid PostDto postDto, @PathVariable("postId") Integer postId){
        PostDto post = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(new ApiResponse("Post Updated successfully",true,post),HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<ApiResponse> getAllPost(){
        List<PostDto> posts = this.postService.getAllPost();
        return new ResponseEntity<>(new ApiResponse("Posts fetched successfully",true,posts),HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> getPostById(@PathVariable("postId") Integer postId){
        PostDto post = this.postService.getPostById(postId);
        return new ResponseEntity<>(new ApiResponse("Post fetched successfully",true,post),HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePostById(@PathVariable("postId") Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted successfully",true),HttpStatus.OK);
    }
    
}
