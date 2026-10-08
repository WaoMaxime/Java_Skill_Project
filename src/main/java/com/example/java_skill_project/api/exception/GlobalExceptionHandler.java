package com.example.java_skill_project.api.exception;

import com.example.java_skill_project.application.exception.FitnessNotFoundException;
import com.example.java_skill_project.domain.exception.InvalidFitnessNameException;
import com.example.java_skill_project.domain.exception.InvalidQualitySettingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FitnessNotFoundException.class)
    public ResponseEntity<String> handleException(FitnessNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidFitnessNameException.class)
    public ResponseEntity<String> handleException(InvalidFitnessNameException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidQualitySettingException.class)
    public ResponseEntity<String> handleException(InvalidQualitySettingException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
