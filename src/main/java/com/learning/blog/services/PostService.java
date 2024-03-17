package com.learning.blog.services;

import java.util.List;

import com.learning.blog.payloads.PostDto;
import com.learning.blog.payloads.PostPaginationResponse;

public interface PostService {
    PostDto createPost(PostDto postDto, int userId, int categoryId);
    PostDto updatePost(PostDto postDto , Integer postId);
    void deletePost(Integer postId);
    PostDto getPostById(Integer postId);
    PostPaginationResponse getAllPost(Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
    List<PostDto> getAllPostByCategory(long categoryId);
    List<PostDto> getAllPostByUser(int userId);
}
