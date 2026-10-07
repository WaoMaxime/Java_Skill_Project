package com.example.java_skill_project.api.mapper.response;

import java.util.UUID;

public record FitnessResponse(
        UUID id,
        String name,
        AddressResponse address,
        int qualityIndex,
        OpeningHoursResponse openingTime
) {}
