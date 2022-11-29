package com.epsiBibliProjet.librairie.dto;


import com.epsiBibliProjet.librairie.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor

public class UserDto
{
    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public User convertToUser()
    {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}