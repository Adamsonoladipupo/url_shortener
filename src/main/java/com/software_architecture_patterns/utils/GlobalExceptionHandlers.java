package com.software_architecture_patterns.utils;

import com.software_architecture_patterns.exceptons.NonExistingShortCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandlers {
    public ResponseEntity<String> handleNonExistingShortCode(NonExistingShortCodeException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
