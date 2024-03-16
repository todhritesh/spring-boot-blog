package com.learning.blog.services;

import java.util.List;

import com.learning.blog.payloads.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto, int userId, int categoryId);
    PostDto updatePost(PostDto postDto , Integer postId);
    void deletePost(Integer postId);
    PostDto getPostById(Integer postId);
    List<PostDto> getAllPost();
    List<PostDto> getAllPostByCategory(long categoryId);
    List<PostDto> getAllPostByUser(int userId);
}
