package com.example.java_skill_project.domain.exception;

import com.example.java_skill_project.domain.fitness.FitnessId;

public class InvalidQualitySetting extends RuntimeException {
    public InvalidQualitySetting(FitnessId id) {
        super("Invalid quality setting for fitness: " + id);
    }
}
