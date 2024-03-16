package com.learning.blog.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {
    private Integer id;

     @NotBlank(message = "Title is required")
    @Size(min = 2,message = "title must have min 2 chars")
    private String title;
    
    @NotBlank(message = "Description is required")
    @Size(min = 2,message = "Description must have min 10 chars")
    private String description;

    private UserDto user;
    private CategoryDto category;
    private Date createdAt;
    
}
