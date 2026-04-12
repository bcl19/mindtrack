package com.bernardo.mindtrackapi.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
    
    @NotBlank
    private String name;

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