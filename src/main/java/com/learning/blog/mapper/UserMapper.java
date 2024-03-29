package com.learning.blog.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.learning.blog.entities.User;
import com.learning.blog.payloads.UserDto;

@Component
public class UserMapper {

    private User user = new User();

    private UserDto userDto = new UserDto();

    public UserDto toDto(User user){
        this.userDto.setFirstName(user.getFirstName());
        this.userDto.setLastName(user.getLastName());
        this.userDto.setEmail(user.getEmail());
        this.userDto.setAbout(user.getAbout());
        this.userDto.setId(user.getId());
        this.userDto.setPassword(user.getPassword());

        return this.userDto;
    }
    public User toEntity(UserDto dto){
        this.user.setFirstName(dto.getFirstName());
        this.user.setLastName(dto.getLastName());
        this.user.setEmail(dto.getEmail());
        this.user.setAbout(dto.getAbout());
        this.user.setId(dto.getId());
        this.user.setPassword(dto.getPassword());
        return this.user;
    }
}
