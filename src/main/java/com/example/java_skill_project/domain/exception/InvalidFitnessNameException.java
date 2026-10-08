package com.example.java_skill_project.domain.exception;

public class InvalidFitnessNameException extends RuntimeException {
    public InvalidFitnessNameException() {
        super("Invalid fitness name for ID");
    }
}
