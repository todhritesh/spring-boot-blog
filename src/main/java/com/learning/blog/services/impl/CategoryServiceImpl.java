package com.learning.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.blog.entities.Category;
import com.learning.blog.exceptions.ResourceNotFoundException;
import com.learning.blog.mapper.CategoryMapper;
import com.learning.blog.payloads.CategoryDto;
import com.learning.blog.repositories.CategoryRepository;
import com.learning.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category savedCategory = this.categoryRepository.save(this.categoryMapper.toEntity(categoryDto));
        return this.categoryMapper.toDto(savedCategory);
    }

    @Override
    public boolean delteCategory(long catId) {
            Category category = this.categoryRepository.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "id", catId));
            this.categoryRepository.delete(category);
            return true;
        
    }

    @Override
    public CategoryDto getCategoryById(long catId) {
        Category category = this.categoryRepository.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "id", catId));
        return this.categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(cat->new CategoryDto(cat)).collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, long catId) {
        Category category = this.categoryRepository.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "id", catId));
        category.setDescription(categoryDto.getDescription());
        category.setTitle(categoryDto.getTitle());
        Category updatedCategory =  this.categoryRepository.save(category);
        return this.categoryMapper.toDto(updatedCategory);
    }
    
}
