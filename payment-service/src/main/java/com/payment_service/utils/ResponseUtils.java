package com.payment_service.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseUtils {
    public static <T> ResponseEntity<ApiResponse<T>> buildSuccessResponse(T data, HttpStatus status){
        ApiResponse<T> body = new ApiResponse<>();
        body.setTimesTamp(LocalDateTime.now());
        body.setStatus(status.value());
        body.setError(null);
        body.setMessage("Ok");
        body.setPath(null);
        body.setData(data);
        return new ResponseEntity<>(body, status);
    }

    public static ResponseEntity<ApiResponse<Object>> buildErrorResponse(
            HttpStatus status,
            String message,
            HttpServletRequest request){
        ApiResponse<Object> body = new ApiResponse<>();
        body.setTimesTamp(LocalDateTime.now());
        body.setStatus(status.value());
        body.setError(status.getReasonPhrase());
        body.setMessage(message);
        body.setPath(request.getRequestURI());
        body.setData(null);
        return new ResponseEntity<>(body, status);
    }
}
