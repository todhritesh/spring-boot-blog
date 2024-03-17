package com.learning.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learning.blog.entities.Category;
import com.learning.blog.entities.Post;
import com.learning.blog.entities.User;
import com.learning.blog.exceptions.ResourceNotFoundException;
import com.learning.blog.payloads.CategoryDto;
import com.learning.blog.payloads.PostDto;
import com.learning.blog.payloads.PostPaginationResponse;
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
        Post post = this.modelMapper.map(postDto, Post.class);
        Post savedPost = this.postRepository.save(post);
        return this.modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Id", postId));
        this.postRepository.delete(post);
    }

    @Override
    public PostPaginationResponse getAllPost(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {

        Sort sort = null;
        if(sortOrder.equals("asc")){
            sort = Sort.by(sortBy).ascending();
        } else if (sortOrder.equals("desc")){
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = this.postRepository.findAll(pageable);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        PostPaginationResponse postPaginationResponse = new PostPaginationResponse(postDtos, pagePosts.getTotalElements(), pagePosts.getTotalPages(), pagePosts.getSize(), pagePosts.getNumber(),pagePosts.isLast());
        return postPaginationResponse;
    }

    @Override
    public List<PostDto> getAllPostByCategory(long categoryId) {
        CategoryDto category = this.categoryService.getCategoryById(categoryId);
        List<Post> posts = this.postRepository.findByCategory(this.modelMapper.map(category,Category.class));
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }
    
    @Override
    public List<PostDto> getAllPostByUser(int userId) {
        UserDto user = this.userService.getUserById(userId);
        List<Post> posts = this.postRepository.findByUser(this.modelMapper.map(user,User.class));
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }
    
    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }
    
    @Override
    public PostDto updatePost(PostDto postDto , Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Id", postId));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        Post updatedPost = this.postRepository.save(post);
        return this.modelMapper.map(updatedPost,PostDto.class)        ;
    }
    
}
