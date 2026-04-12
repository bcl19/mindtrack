package com.bernardo.mindtrackapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bernardo.mindtrackapi.model.Result;
import com.bernardo.mindtrackapi.repository.ResultRepository;

@RestController
@RequestMapping("/results")
@CrossOrigin(origins = "*")
public class ResultController {
        private final ResultRepository repository;

        public ResultController(ResultRepository repository) {
                this.repository = repository;
        }
@PostMapping
public Result save(@RequestBody Result result) {
       if (result == null) {
               throw new IllegalArgumentException("Result cannot be null");
       }
       return repository.save(result);
}
@GetMapping()
public List<Result> getAll() {
    return repository.findAll();
}
}
