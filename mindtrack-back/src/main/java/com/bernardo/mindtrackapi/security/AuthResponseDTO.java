package com.bernardo.mindtrackapi.security;

public class AuthResponseDTO {
    public String token;

    public AuthResponseDTO(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}
