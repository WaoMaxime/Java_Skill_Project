package com.example.java_skill_project.domain.exception;

public class InvalidOpeningHoursException extends RuntimeException {
    public InvalidOpeningHoursException() {
        super("Opening time must be before closing time");
    }
}
