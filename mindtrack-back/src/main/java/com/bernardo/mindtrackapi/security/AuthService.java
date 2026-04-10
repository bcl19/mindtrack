package com.bernardo.mindtrackapi.security;

import org.springframework.stereotype.Service;

import com.bernardo.mindtrackapi.model.User;
import com.bernardo.mindtrackapi.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository repo;
    private final JwtService jwt;

    public AuthService(UserRepository repo, JwtService jwt) {
        this.repo = repo;
        this.jwt = jwt;
    }

    public AuthResponseDTO login(AuthRequestDTO request) {
        User user = repo.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (user.getPassword() == null || 
            !user.getPassword().equals(request.password)) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwt.generateToken(user);
        return new AuthResponseDTO(token);
    }

    public AuthResponseDTO register(AuthRequestDTO request) {
        User user = new User();
        user.setEmail(request.email);
        user.setPassword(request.password);
        user.setName(request.name);

        repo.save(user);

        String token = jwt.generateToken(user);
        return new AuthResponseDTO(token);
    }
}