package com.bernardo.mindtrackapi.dto.auth;

public record LoginResponseDTO (

    String token,
    String type
) {
    public LoginResponseDTO(String token) {
        this(token, "Bearer");
    }

    public String getToken() { 
        return token; 
    }
    public String getType() {
         return type; 
        }
}