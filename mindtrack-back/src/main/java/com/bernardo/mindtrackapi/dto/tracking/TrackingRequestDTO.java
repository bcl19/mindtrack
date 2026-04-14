package com.bernardo.mindtrackapi.dto.tracking;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record TrackingRequestDTO(@NotNull String habitId, @NotNull LocalDate date, boolean completed) {
    public String getHabitId() { return habitId; }
    public LocalDate getDate() { return date; }
    public boolean isCompleted() { return completed; }
}