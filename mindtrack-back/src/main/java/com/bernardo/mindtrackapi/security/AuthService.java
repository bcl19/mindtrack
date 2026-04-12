package com.bernardo.mindtrackapi.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bernardo.mindtrackapi.model.User;
import com.bernardo.mindtrackapi.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository repo;
    private final JwtService jwt;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository repo, JwtService jwt) {
        this.repo = repo;
        this.jwt = jwt;
    }

    public AuthResponseDTO login(AuthRequestDTO request) {
        User user = repo.findByEmail(request.email).orElse(null);

        if (user == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        if (!encoder.matches(request.password, user.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwt.generateToken(user);
        return new AuthResponseDTO(token);
    }

    public AuthResponseDTO register(AuthRequestDTO request) {
        if (repo.findByEmail(request.email).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(encoder.encode(request.password)); // 🔐 CORRETO
        user.setRole(user.getRole()); // default USER

        repo.save(user);

        String token = jwt.generateToken(user);
        return new AuthResponseDTO(token);
    }
}