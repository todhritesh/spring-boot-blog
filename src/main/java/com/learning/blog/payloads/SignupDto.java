package com.learning.blog.payloads;

import com.learning.blog.entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupDto  {
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
