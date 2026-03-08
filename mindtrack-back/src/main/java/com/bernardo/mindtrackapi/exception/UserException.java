package com.bernardo.mindtrackapi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class UserException {
        private String message;
}
