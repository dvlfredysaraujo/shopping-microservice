package com.order_service.config;

import com.order_service.exception.BadRequestException;
import com.order_service.exception.OrderValidationException;
import com.order_service.exception.ResourceNotFoundException;
import com.order_service.utils.ApiResponse;
import com.order_service.utils.ResponseUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderValidationException.class)
    public ResponseEntity<ApiResponse<Object>> handleOrderValidationException(OrderValidationException ex,
                                                                              HttpServletRequest request) {
        return ResponseUtils.buildErrorResponse(
                org.springframework.http.HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                request
        );
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(Exception ex,
                                                                       HttpServletRequest request) {
        return ResponseUtils.buildErrorResponse(
                org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred: " + ex.getMessage(),
                request
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequestException(BadRequestException ex,
                                                                          HttpServletRequest request) {
        return ResponseUtils.buildErrorResponse(
                org.springframework.http.HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                request
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                               HttpServletRequest request) {
        return ResponseUtils.buildErrorResponse(
                org.springframework.http.HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request
        );
    }
}
