package com.example.java_skill_project.domain.fitness;

import org.jmolecules.ddd.annotation.ValueObject;
import java.time.LocalTime;

@ValueObject
public record FitnessOpeningHours(LocalTime openingTime, LocalTime closingTime) {
}
