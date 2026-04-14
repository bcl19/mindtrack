package com.bernardo.mindtrackapi.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(@NotBlank @Size(min = 3, max = 100) String name, @Email @NotBlank String email, @NotBlank @Size(min = 6) String password) {
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}