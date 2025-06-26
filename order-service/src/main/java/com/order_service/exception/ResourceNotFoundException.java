package com.order_service.exception;

public class ResourceNotFoundException extends RuntimeException{
    private final static long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
