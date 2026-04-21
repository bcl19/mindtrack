package com.bernardo.mindtrackapi.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    public String getProfile(Map<String,Double> scores) {
        double ansiedade = scores.getOrDefault("ansiedade", 0.0);
        double energia = scores.getOrDefault("energia", 0.0);
        if (ansiedade > 7 && energia < 3) {
            return "Perfil Ansioso";
        } else if (ansiedade < 4 && energia > 6) {
            return "Perfil Energético";
        } else {
            return "Perfil Equilibrado";
        }
}
}
