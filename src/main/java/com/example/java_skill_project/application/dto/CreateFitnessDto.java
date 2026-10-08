package com.example.java_skill_project.application.dto;

import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.shared.OpeningHours;

public record CreateFitnessDto(
        String name,
        Address address,
        int qualityIndex,
        OpeningHours openingHours
) {}
