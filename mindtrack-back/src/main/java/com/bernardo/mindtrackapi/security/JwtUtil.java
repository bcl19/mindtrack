package com.bernardo.mindtrackapi.security;

import java.util.Date;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final SecretKey SECRET = Keys.hmacShaKeyFor(
        "segredo-super-seguro-seguro-123456".getBytes()
    );

    // 🔥 gera token
    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1h
                .signWith(SECRET)
                .compact();
    }

    // 🔥 extrai email
    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith(SECRET)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // 🔥 valida token (opcional mas recomendado)
    public boolean isTokenValid(String token) {
        try {
            extractEmail(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}