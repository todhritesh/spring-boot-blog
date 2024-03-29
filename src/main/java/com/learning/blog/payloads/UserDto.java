package com.learning.blog.payloads;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.learning.blog.entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = {"password"})
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

    @NotBlank(message = "First name should not be empty")
    @Size(min = 3, max = 20 , message = "First name should must be 3 - 20 chars")
    private String firstName;
    

    @NotBlank(message = "Last name should not be empty")
    @Size(min = 3, max = 20 , message = "Last name should must be 3 - 20 chars")
    private String lastName;
    
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email should not be empty")
    private String email;
    
    @NotBlank(message = "Password should not be empty")
    @Size(min = 6, max = 10 , message = "Password should must be 6 - 10 chars")
    private String password;
    private Role role;

    private String about;
}
