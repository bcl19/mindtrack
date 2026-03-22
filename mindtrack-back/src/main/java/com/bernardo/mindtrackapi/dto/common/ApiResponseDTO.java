package com.bernardo.mindtrackapi.dto.common;

public class ApiResponseDTO<T> {

    private final String message;
    private final T data;

    public ApiResponseDTO(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() { return message; }
    public T getData() { return data; }
}