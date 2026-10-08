package com.example.java_skill_project.domain.shared;

import org.jmolecules.ddd.annotation.ValueObject;
import java.time.LocalTime;

@ValueObject
public record OpeningHours(
        LocalTime openingTime,
        LocalTime closingTime
) {}
