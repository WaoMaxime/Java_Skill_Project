package com.example.java_skill_project.domain.fitness;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record QualityRange(int min, int max) {

    public QualityRange {
        if (min > max) {
            throw new IllegalArgumentException(
                    "Minimum quality cannot exceed maximum"
            );
        }
    }

    public boolean contains(int value) {
        return value >= min && value <= max;
    }
}
