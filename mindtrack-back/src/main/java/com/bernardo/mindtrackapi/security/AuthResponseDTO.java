package com.bernardo.mindtrackapi.security;

public record AuthResponseDTO (
    String token
) {
    public String getToken() {
        return token;
    }
}
