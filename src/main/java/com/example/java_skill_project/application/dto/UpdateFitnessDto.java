package com.example.java_skill_project.application.dto;

import com.example.java_skill_project.domain.fitness.QualityChange;
import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.shared.OpeningHours;

public record UpdateFitnessDto(
        String name,
        Address address,
        QualityChange qualityIndex,
        OpeningHours openingHours
) {}
