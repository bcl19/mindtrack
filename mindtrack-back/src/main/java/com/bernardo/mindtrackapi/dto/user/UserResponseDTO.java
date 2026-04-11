package com.bernardo.mindtrackapi.dto.user;

public record UserResponseDTO (
     String id,
     String name,
     String email
){

    public String getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public String getEmail() { 
        return email; 
    }
}