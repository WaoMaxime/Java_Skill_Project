package com.example.java_skill_project.api.mapper.request;

import com.example.java_skill_project.domain.address.Address;
import com.example.java_skill_project.domain.fitness.FitnessOpeningHours;
import com.example.java_skill_project.domain.fitness.QualityChange;

public record FitnessRequest(
        String name,
        Address address,
        QualityChange qualityIndex,
        FitnessOpeningHours openingHours
) {}
