package com.bernardo.mindtrackapi.controller;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.mindtrackapi.dto.user.UserResponseDTO;
import com.bernardo.mindtrackapi.model.User;
import com.bernardo.mindtrackapi.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<UserResponseDTO> getAll() {
        return repo.findAll().stream()
                .map(user -> new UserResponseDTO(
                        user.getId().toString(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable @NonNull Long id) {
        User user = repo.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found " + id));

        return new UserResponseDTO(
                user.getId().toString(),
                user.getName(),
                user.getEmail()
        );
    }
}