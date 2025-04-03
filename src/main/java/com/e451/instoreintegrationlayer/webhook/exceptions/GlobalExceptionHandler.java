package com.e451.instoreintegrationlayer.webhook.exceptions;

import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@Order(-2)
public class GlobalExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(WebExchangeBindException ex) {
        List<FieldErrorDetail> errors = ex.getFieldErrors().stream()
                .map(error -> new FieldErrorDetail(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(new ValidationErrorResponse(400, "Validation failed", errors));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        List<FieldErrorDetail> errors = ex.getConstraintViolations().stream()
                .map(error -> new FieldErrorDetail(error.getPropertyPath().toString(), error.getMessage()))
                .toList();

        return ResponseEntity.badRequest().body(new ValidationErrorResponse(400, "Constraint violation", errors));
    }

    // Fallback exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ValidationErrorResponse> handleException(Exception ex) {
        log.error("Unhandled error occurred: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ValidationErrorResponse(500, ex.getMessage(), List.of()));
    }

    @Data
    @AllArgsConstructor
    static class ValidationErrorResponse {
        private int status;
        private String message;
        private List<FieldErrorDetail> errors;
    }

    @Data
    @AllArgsConstructor
    static class FieldErrorDetail {
        private String field;
        private String message;
    }
}


