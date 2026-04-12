package com.bernardo.mindtrackapi.security;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {
        return service.login(request);
    }

    @PostMapping("/register")
    public AuthResponseDTO register(@RequestBody AuthRequestDTO request) {
        return service.register(request);
    }
}