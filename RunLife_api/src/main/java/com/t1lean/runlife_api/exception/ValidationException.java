package com.t1lean.runlife_api.exception;

public class ValidationException extends  RuntimeException{

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}