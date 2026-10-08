package com.example.java_skill_project.api.response;

import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.shared.OpeningHours;

import java.util.UUID;

public record FitnessResponse(
        UUID id,
        String name,
        Address address,
        int qualityIndex,
        OpeningHours openingTime
) {}

