package com.bernardo.mindtrackapi.security;

public record AuthRequestDTO (
    String name,
    String email,
    String password
) {
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
    

