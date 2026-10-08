package com.example.java_skill_project.api.validation;

import com.example.java_skill_project.domain.fitness.FitnessProperties;
import jakarta.validation.ConstraintValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FitnessQualityValidator implements ConstraintValidator<ValidFitnessQuality, Integer> {

    private final FitnessProperties fitnessProperties;

    @Override
    public boolean isValid(Integer value, jakarta.validation.ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Consider null as valid, use @NotNull for null checks
        }
        return value >= fitnessProperties.minQuality() && value <= fitnessProperties.maxQuality();
    }
}
