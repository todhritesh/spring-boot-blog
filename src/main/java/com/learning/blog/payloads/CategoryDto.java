package com.learning.blog.payloads;

import com.learning.blog.entities.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {


    private long id;

    @NotBlank(message = "Title is required")
    @Size(min = 2,message = "title must have min 2 chars")
    private String title;
    
    @NotBlank(message = "Description is required")
    @Size(min = 2,message = "title must have min 10 chars")
    private String description;

    public CategoryDto (Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.description = category.getDescription();
    }

}
