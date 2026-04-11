package com.bernardo.mindtrackapi.exception;

import java.time.LocalDateTime;

public record ErrorResponse (
    String message,
    int status,
    LocalDateTime timestamp
){
    public String getMessage() { 
        return message; 
    }
    public int getStatus() { 
        return status; 
    }
    public LocalDateTime getTimestamp() {
         return timestamp; 
        }
}