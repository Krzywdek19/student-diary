package com.krzywdek19.student_diary.common.exception;

import com.krzywdek19.student_diary.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(Exception ex, HttpServletRequest request) {
        return ResponseEntity
                .status(500)
                .body(
                        ResponseUtil
                                .error(ex.getMessage(),"An unexpected error occured", 500, request.getRequestURI())
                );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(404)
                .body(
                        ResponseUtil
                                .error(ex.getMessage(), "Resource not found exception", 404, request.getRequestURI())
                );
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResponseNotFoundException(ResponseNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(204)
                .body(ResponseUtil
                        .error(ex.getMessage(),"Response not found exception", 204, request.getRequestURI())
                );
    }
}
