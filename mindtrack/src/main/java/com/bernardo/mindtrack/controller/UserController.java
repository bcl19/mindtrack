package com.bernardo.mindtrack.controller;

import com.bernardo.mindtrack.dto.UserCreateRequest;
import com.bernardo.mindtrack.dto.UserResponse;
import com.bernardo.mindtrack.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse create(@RequestBody @Valid UserCreateRequest request) {
        return userService.create(request);
    }
}
