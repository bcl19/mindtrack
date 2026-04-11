package com.bernardo.mindtrackapi.dto.tracking;

import java.time.LocalDate;

public record TrackingResponseDTO (
    String id,
    String habitId,
    LocalDate date,
    boolean completed
) {
    public String getId() { 
        return id; 
    }
    public String getHabitId() { 
        return habitId; 
    }
    public LocalDate getDate() { 
        return date; 
    }
    public boolean isCompleted() { 
        return completed; 
    }
}