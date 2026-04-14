package com.bernardo.mindtrackapi.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(@Email @NotBlank String email, @NotBlank String password, @NotBlank String name) {
    public String getName() { 
        return name;
}
    public String getEmail() { 
        return email;
     }
    public String getPassword() { 
        return password; 
    }
}