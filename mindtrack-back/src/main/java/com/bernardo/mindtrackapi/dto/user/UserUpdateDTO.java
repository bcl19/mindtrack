package com.bernardo.mindtrackapi.dto.user;

import jakarta.validation.constraints.Size;

public class UserUpdateDTO {

    @Size(min = 3, max = 100)
    private String name;

    public String getName() { return name; }
}