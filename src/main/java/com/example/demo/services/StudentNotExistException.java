package com.example.demo.services;

public class StudentNotExistException extends RuntimeException {

    public StudentNotExistException() {
    }

    public StudentNotExistException(String message) {
        super(message);
    }

    public StudentNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotExistException(Throwable cause) {
        super(cause);
    }

    public StudentNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
