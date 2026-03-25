package com.bernardo.mindtrackapi.security;

import com.bernardo.mindtrackapi.model.User;
import org.springframework.stereotype.Service;
import com.bernardo.mindtrackapi.security.JwtFilter;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET = "minha-chave-super-secreta-123456789";
    private final long EXPIRATION = 1000 * 60 * 60 * 24; // 1 dia

    private Key getKey() {
        return org.springframework.data.repository.query.QueryLookupStrategy.Key.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("role", user.getRole().name())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getKey())
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}