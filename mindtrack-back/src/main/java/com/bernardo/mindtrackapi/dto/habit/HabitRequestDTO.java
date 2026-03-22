package com.bernardo.mindtrackapi.dto.habit;

import jakarta.validation.constraints.NotBlank;

public class HabitRequestDTO {

    @NotBlank
    private String title;

    private String description;

    public String getTitle() { return title; }
    public String getDescription() { return description; }
}