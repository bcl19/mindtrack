package com.bernardo.mindtrackapi.dto.habit;

public record HabitResponseDTO(String id, String title, String description){
    
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}