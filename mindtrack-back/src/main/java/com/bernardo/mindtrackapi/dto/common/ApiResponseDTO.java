package com.bernardo.mindtrackapi.dto.common;

public record ApiResponseDTO<T>(String message, T data) {
    public String getMessage() { return message; }
    public T getData() { return data; }
}