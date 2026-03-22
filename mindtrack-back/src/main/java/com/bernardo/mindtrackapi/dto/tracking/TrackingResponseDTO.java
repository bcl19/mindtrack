package com.bernardo.mindtrackapi.dto.tracking;

import java.time.LocalDate;

public class TrackingResponseDTO {

    private final String id;
    private final String habitId;
    private final LocalDate date;
    private final boolean completed;

    public TrackingResponseDTO(String id, String habitId, LocalDate date, boolean completed) {
        this.id = id;
        this.habitId = habitId;
        this.date = date;
        this.completed = completed;
    }

    public String getId() { return id; }
    public String getHabitId() { return habitId; }
    public LocalDate getDate() { return date; }
    public boolean isCompleted() { return completed; }
}