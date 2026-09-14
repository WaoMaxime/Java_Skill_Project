package com.example.java_skill_project.application.exception;

import com.example.java_skill_project.domain.fitness.FitnessId;

public class FitnessNotFoundException extends RuntimeException {
    public FitnessNotFoundException(FitnessId id) {
        super("Fitness not found: " + id);
    }
}
