package com.bernardo.mindtrackapi.service;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bernardo.mindtrackapi.dto.tracking.ResultQuizDTO;
@Service
public class QuizService {

    @Autowired
    private PontuacaoService pontuacaoService;

    @Autowired
    private ProfileService perfilService;

    public ResultQuizDTO processarQuiz(List<ResultQuizDTO> respostas) {
        Map<String, Double> bruto = pontuacaoService.somarImpactos(respostas);
        Map<String, Double> normalizado = pontuacaoService.normalizar(bruto, 10);
        String perfil = perfilService.getProfile(normalizado);
        return new ResultQuizDTO(normalizado, perfil);
    }
}