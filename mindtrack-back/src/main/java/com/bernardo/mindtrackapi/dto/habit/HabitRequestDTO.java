package com.bernardo.mindtrackapi.dto.habit;

import jakarta.validation.constraints.NotBlank;
public record HabitRequestDTO (@NotBlank String title, String description) {

    public String getTitle() { return title; }
    public String getDescription() { return description; }
}