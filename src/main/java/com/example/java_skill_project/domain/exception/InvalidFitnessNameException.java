package com.example.java_skill_project.domain.exception;

import com.example.java_skill_project.domain.fitness.FitnessId;

public class InvalidFitnessNameException extends RuntimeException {
    public InvalidFitnessNameException(FitnessId id) {
        super("Invalid fitness name for ID: " + id);
    }
}
