package com.example.java_skill_project.domain.fitness;

import org.jmolecules.ddd.annotation.ValueObject;

import java.util.UUID;

@ValueObject
public record fitnessId(UUID id) {
    private static UUID New(){
        return UUID.randomUUID();
    }
}
