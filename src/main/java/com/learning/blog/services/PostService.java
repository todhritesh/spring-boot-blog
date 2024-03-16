package com.learning.blog.services;

import com.learning.blog.payloads.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto, int userId, int categoryId);
    PostDto updatePost(PostDto postDto);
    void deletePost(PostDto postDto);
    PostDto getPostById(long postId);
    PostDto getAllPost();
    PostDto getAllPostByCategory(long categoryId);
    PostDto getAllPostByUser(long userId);
}
