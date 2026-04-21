package com.bernardo.mindtrackapi.service;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bernardo.mindtrackapi.dto.tracking.ResultQuizDTO;

@Service
public class PontuacaoService {
    public Map<String, Double> somarImpactos(List<ResultQuizDTO> respostas) {
        Map<String, Double> bruto = new HashMap<>();
        for (ResultQuizDTO resposta : respostas) {
            String categoria = resposta.getPerfil();
            Map<String, Double> impacto = resposta.getScores();
            for (Map.Entry<String, Double> entry : impacto.entrySet()) {
                bruto.put(categoria, bruto.getOrDefault(categoria, 0.0) + entry.getValue());
            }
        }
        return bruto;
    }

    public Map<String, Double> normalizar(Map<String, Double> bruto, int maxScore) {
        Map<String, Double> normalizado = new HashMap<>();
        for (Map.Entry<String, Double> entry : bruto.entrySet()) {
            normalizado.put(entry.getKey(), entry.getValue() / (double) maxScore);
        }   return normalizado;
    }
}