package com.example.java_skill_project.api.mapper;

import com.example.java_skill_project.api.mapper.response.FitnessResponse;
import com.example.java_skill_project.application.dto.FitnessDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public FitnessResponse toFitnessResponse(FitnessDto dto) {
        return new FitnessResponse(), dto.fitness().getName(), dto.fitness().getQualityIndex());
    }
}
