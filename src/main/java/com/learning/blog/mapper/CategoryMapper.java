package com.learning.blog.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.blog.entities.Category;
import com.learning.blog.payloads.CategoryDto;

@Component
public class CategoryMapper {
    
    @Autowired
    private Category category;

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
