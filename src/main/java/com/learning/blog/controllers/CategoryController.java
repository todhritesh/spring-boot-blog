package com.learning.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.learning.blog.payloads.ApiResponse;
import com.learning.blog.payloads.CategoryDto;
import com.learning.blog.services.CategoryService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody @Valid CategoryDto categoryDto){
        CategoryDto cat =  this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(new ApiResponse("Category created successfully",true,cat),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable long id, @RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto cat =  this.categoryService.updateCategory(categoryDto, id);
        return new ResponseEntity<>(new ApiResponse("Category updated successfully",true,cat),HttpStatus.OK);
    }
    
    @GetMapping("/{catId}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable long catId) {
        CategoryDto cat =  this.categoryService.getCategoryById(catId);
        return new ResponseEntity<>(new ApiResponse("Category fetched successfully",true,cat),HttpStatus.OK);
    }
    
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable long catId) {
        boolean isDeleted =  this.categoryService.delteCategory(catId);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully",isDeleted),HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getCategoryById() {
        List<CategoryDto> categories =  this.categoryService.getAllCategory();
        return new ResponseEntity<>(new ApiResponse("Categories fetched successfully",true,categories),HttpStatus.OK);
    }
}
