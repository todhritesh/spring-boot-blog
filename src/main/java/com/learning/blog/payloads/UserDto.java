package com.learning.blog.payloads;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class UserDto {
    public UserDto(UserDto dto) {
        this.id=dto.id;
        this.firstName=dto.firstName;
        this.lastName=dto.lastName;
        this.email=dto.email;
        this.password=dto.password;
        this.about=dto.about;
    }

    private int id;

    private String firstName;

    private String lastName;

    private String email;
    
    private String password;
    
    private String about;
}
