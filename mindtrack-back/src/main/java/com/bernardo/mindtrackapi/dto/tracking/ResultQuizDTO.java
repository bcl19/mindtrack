package com.bernardo.mindtrackapi.dto.tracking;

import java.util.Map;

public class ResultQuizDTO {
    private final Map<String, Double> scores;
    private final String perfil;

    public ResultQuizDTO(Map<String, Double> scores, String perfil) {
        this.scores = scores;
        this.perfil = perfil;
    }
    public Map<String, Double> getScores() {
        return scores;
    }
    public String getPerfil() {
        return perfil;
    }
}
