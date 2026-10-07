package com.example.java_skill_project.api.mapper.request;

import com.example.java_skill_project.domain.address.Address;
import com.example.java_skill_project.domain.fitness.FitnessOpeningHours;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

public record CreateFitnessRequest(
        @NotBlank String name,
        @Nonnull Address address,
        int qualityIndex,
        @Nonnull FitnessOpeningHours openingHours
) {}
