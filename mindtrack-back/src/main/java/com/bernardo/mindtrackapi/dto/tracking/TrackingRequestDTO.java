package com.bernardo.mindtrackapi.dto.tracking;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class TrackingRequestDTO {

    @NotNull
    private String habitId;

    @NotNull
    private LocalDate date;

    private boolean completed;

    public String getHabitId() { return habitId; }
    public LocalDate getDate() { return date; }
    public boolean isCompleted() { return completed; }
}