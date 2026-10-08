package com.example.java_skill_project.application.mapper;

import com.example.java_skill_project.application.dto.FitnessDto;
import com.example.java_skill_project.domain.fitness.Fitness;
import org.springframework.stereotype.Component;

@Component
public class FitnessDtoMapper {
    public FitnessDto toFitnessDto(Fitness fitness) {
        return new FitnessDto(
                fitness.getId().id(),
                fitness.getName(),
                fitness.getAddress(),
                fitness.getQualityIndex(),
                fitness.getOpeningHours()
        );
    }
}
