package com.learning.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @NotBlank(message = "Email should not be empty")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password should not be empty")
    @Size(min = 6, max = 10 , message = "Password should must be 6 - 10 chars")
    private String password;
}
