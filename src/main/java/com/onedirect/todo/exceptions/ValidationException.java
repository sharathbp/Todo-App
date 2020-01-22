package com.onedirect.todo.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message){
        super(message);
    }
    public ValidationException() {
    }
}
