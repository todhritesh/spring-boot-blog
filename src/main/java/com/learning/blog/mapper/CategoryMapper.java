package com.learning.blog.mapper;

import org.springframework.stereotype.Component;

import com.learning.blog.entities.Category;
import com.learning.blog.payloads.CategoryDto;

@Component
public class CategoryMapper {
    
    private Category category = new Category();

    private CategoryDto categoryDto = new CategoryDto();

    public Category toEntity(CategoryDto categoryDto) {
        this.category.setId(categoryDto.getId());
        this.category.setDescription(categoryDto.getDescription());
        this.category.setTitle(categoryDto.getTitle());
        return category;
    }

    public CategoryDto toDto(Category category) {
        this.categoryDto.setId(category.getId());
        this.categoryDto.setDescription(category.getDescription());
        this.categoryDto.setTitle(category.getTitle());
        return categoryDto;
    }
}
