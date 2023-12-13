package com.example.todobackend.exception;

import lombok.Getter;

@Getter
public class TodoException extends RuntimeException {
    private final String message;
    public TodoException(String message) {
        super(message);
        this.message = message;
    }
}
