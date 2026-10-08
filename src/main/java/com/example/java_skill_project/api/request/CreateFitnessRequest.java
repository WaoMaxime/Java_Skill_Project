package com.example.java_skill_project.api.request;

import com.example.java_skill_project.api.validation.ValidFitnessQuality;
import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.shared.OpeningHours;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateFitnessRequest(
        @NotBlank String name,
        @NotNull Address address,
        @ValidFitnessQuality int qualityIndex,
        @NotNull OpeningHours openingHours
) {}
