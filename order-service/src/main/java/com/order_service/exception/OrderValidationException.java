package com.order_service.exception;

public class OrderValidationException extends RuntimeException{
    private final static long serialVersionUID = 1L;

    public OrderValidationException(String message) {
        super(message);
    }

    public OrderValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
