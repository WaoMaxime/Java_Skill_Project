package com.example.java_skill_project.api.request;

import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.shared.OpeningHours;
import com.example.java_skill_project.domain.fitness.QualityChange;

public record FitnessRequest(
        String name,
        Address address,
        QualityChange qualityIndex,
        OpeningHours openingHours
) {}
