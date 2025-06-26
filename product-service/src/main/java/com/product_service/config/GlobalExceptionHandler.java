package com.product_service.config;

import com.product_service.exception.BadRequestException;
import com.product_service.exception.ExternalServiceException;
import com.product_service.exception.ResourceNotFoundException;
import com.product_service.utils.ApiResponse;
import com.product_service.utils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(ResourceNotFoundException ex,
                                                              HttpServletRequest request) {
        return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequestException(BadRequestException ex,
                                                                HttpServletRequest request) {
        return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<ApiResponse<Object>> handleExternalServiceException(ExternalServiceException ex,
                                                                              HttpServletRequest request) {
        return ResponseUtils.buildErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex,
                                                                       HttpServletRequest request) {
        return ResponseUtils.buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred: " + ex.getMessage(), request);
    }
}
