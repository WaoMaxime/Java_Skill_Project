package com.example.java_skill_project.application.dto;
import com.example.java_skill_project.domain.fitness.Fitness;

public record FitnessDto(Fitness fitness)
{
    public static Fitness toDomain(FitnessDto dto) {
        return Fitness.builder()
                .id(dto.fitness().getId())
                .name(dto.fitness().getName())
                .address(dto.fitness().getAddress())
                .qualityIndex(dto.fitness().getQualityIndex())
                .openingTime(dto.fitness().getOpeningTime())
                .build();
    }

    public static FitnessDto fromDomain(Fitness fitness) {
        return new FitnessDto(fitness);
    }
}
