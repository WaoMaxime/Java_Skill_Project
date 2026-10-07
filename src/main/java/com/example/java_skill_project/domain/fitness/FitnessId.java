package com.example.java_skill_project.domain.fitness;

import org.jmolecules.ddd.annotation.ValueObject;
import org.springframework.util.Assert;

import java.util.UUID;

@ValueObject
public record FitnessId(UUID id) {

    public FitnessId {
        Assert.notNull(id, "FitnessId must not be null");
    }

    public static FitnessId create() {
        return new FitnessId(UUID.randomUUID());
    }

    public static FitnessId from(UUID value) {
        return new FitnessId(value);
    }
}
