package com.mastermanagement.mastermanagement.exception;

import com.mastermanagement.mastermanagement.exception.exceptions.*;
import com.mastermanagement.mastermanagement.exception.exceptions.Error;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Wrong request: " + e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final EntityExistsException ex, final Locale locale) {
        final Error error = ErrorUtils
                .createError(ErrorCode.ENTITY_EXIST.getCode(),
                        String.format("%s, %s", ErrorCode.ENTITY_EXIST.getMessageKey(),
                                ex.getMessage()),
                        HttpStatus.NOT_ACCEPTABLE.value())
                .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final BusinessRuleException ex, final Locale locale) {
        final Error error = ErrorUtils
                .createError(ErrorCode.BUSINESS_RULE_VIOLATION.getCode(), ex.formatException(),
                        HttpStatus.BAD_REQUEST.value())
                .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotExistsException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final EntityNotExistsException ex, final Locale locale) {
        final Error error = ErrorUtils
                .createError(ErrorCode.ENTITY_NOT_EXIST.getCode(),
                        String.format("%s, %s",
                                ErrorCode.ENTITY_NOT_EXIST.getMessageKey(),
                                ex.getMessage()),
                        HttpStatus.NOT_FOUND.value())
                .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
