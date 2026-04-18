package com.bernardo.mindtrackapi.controller;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")

public class HomeController {

    // Endpoint público (não precisa de token)
    @GetMapping
    public Map<String, String> home() {
        return Map.of(
                "status", "online",
                "service", "MindTrack API"
        );
    }

    // Endpoint protegido (precisa de JWT)
    @GetMapping("secure")
    public Map<String, String> secure() {
        return Map.of(
                "message", "Acesso autorizado",
                "auth", "JWT OK"
        );
    }
}