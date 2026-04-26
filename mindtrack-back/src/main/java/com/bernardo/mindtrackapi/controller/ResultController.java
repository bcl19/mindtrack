package com.bernardo.mindtrackapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bernardo.mindtrackapi.dto.tracking.ResultRequest;
import com.bernardo.mindtrackapi.dto.tracking.ResultResponse;
import com.bernardo.mindtrackapi.model.Result;
import com.bernardo.mindtrackapi.repository.ResultRepository;

@RestController
@RequestMapping("/result")
@CrossOrigin(origins = "http://localhost:5173")
public class ResultController {

    private final ResultRepository repository;

    public ResultController(ResultRepository repository) {
        this.repository = repository;
    }

    // 🔥 POST preparado pro frontend
    @PostMapping
    public ResultResponse save(@RequestBody ResultRequest request) {

        // 🔹 validação básica
        if (request.getEnergia() < 0 || request.getEnergia() > 10) {
            throw new IllegalArgumentException("Energia deve ser entre 0 e 10");
        }

        if (request.getAnsiedade() < 0 || request.getAnsiedade() > 10) {
            throw new IllegalArgumentException("Ansiedade deve ser entre 0 e 10");
        }

        // 🔹 cria entidade
        Result result = new Result();
        result.setEnergia(request.getEnergia());
        result.setAnsiedade(request.getAnsiedade());

        // 🔹 salva
        Result saved = repository.save(result);

        // 🔹 retorna já no formato do gráfico
        return new ResultResponse(
            saved.getCreatedAt().toLocalDate().toString(),
            calculateMood(saved)
        );
    }

    // 🔥 GET já pronto pro gráfico
    @GetMapping
    public List<ResultResponse> getAll() {
        return repository.findAll()
            .stream()
            .map(r -> new ResultResponse(
                r.getCreatedAt().toLocalDate().toString(),
                calculateMood(r)
            ))
            .toList();
    }

    // 🔹 lógica de negócio
    private int calculateMood(Result r) {
        return (r.getEnergia() - r.getAnsiedade() + 10) / 2;
    }
}