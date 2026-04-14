package com.bernardo.mindtrackapi.dto.user;

import jakarta.validation.constraints.Size;

public record UserUpdateDTO(@Size(min = 3, max = 100) String name) {
    public String getName() {
        return name;
    }
}