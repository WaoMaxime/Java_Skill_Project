package com.example.java_skill_project.application.dto;

import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.shared.OpeningHours;

import java.util.UUID;

public record FitnessDto(
        UUID id,
        String name,
        Address address,
        int qualityIndex,
        OpeningHours openingHours
) {}
