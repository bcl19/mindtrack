package com.bernardo.mindtrackapi.dto.auth;

public class LoginResponseDTO {

    private final String token;
    private final String type = "Bearer";

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() { return token; }
    public String getType() { return type; }
}