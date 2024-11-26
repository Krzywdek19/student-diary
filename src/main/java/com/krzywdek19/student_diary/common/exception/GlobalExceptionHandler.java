package com.krzywdek19.student_diary.common.exception;

import com.krzywdek19.student_diary.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleGeneralException(Exception ex, HttpServletRequest request) {
        return ResponseUtil
                .error(ex.getMessage(),"An unexpected error occured", 1001, request.getRequestURI());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Object> handleResourceNotFoundException(ResponseNotFoundException ex, HttpServletRequest request) {
        return ResponseUtil
                .error(ex.getMessage(),"Resource not found exception", 404, request.getRequestURI());
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    public ApiResponse<Object> handleResponseNotFoundException(ResponseNotFoundException ex, HttpServletRequest request) {
        return ResponseUtil
                .error(ex.getMessage(),"Response not found exception", 204, request.getRequestURI());
    }
}
