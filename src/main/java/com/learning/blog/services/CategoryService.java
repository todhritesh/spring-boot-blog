package com.learning.blog.services;

import java.util.List;

import com.learning.blog.payloads.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto , long catId);
    boolean delteCategory(long catId);
    CategoryDto getCategoryById(long catId);
    List<CategoryDto> getAllCategory();
}
