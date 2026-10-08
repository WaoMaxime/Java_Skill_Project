package com.example.java_skill_project.api.mapper;

import com.example.java_skill_project.api.request.CreateFitnessRequest;
import com.example.java_skill_project.api.request.FitnessRequest;
import com.example.java_skill_project.api.response.FitnessResponse;
import com.example.java_skill_project.application.dto.CreateFitnessDto;
import com.example.java_skill_project.application.dto.FitnessDto;
import com.example.java_skill_project.application.dto.UpdateFitnessDto;
import org.springframework.stereotype.Component;

@Component
public class FitnessApiMapper {
    public FitnessResponse toResponse(FitnessDto fitness) {
        return new FitnessResponse(
                fitness.id(),
                fitness.name(),
                fitness.address(),
                fitness.qualityIndex(),
                fitness.openingHours()
        );
    }

    public CreateFitnessDto toDto(CreateFitnessRequest request) {
        return new CreateFitnessDto(
                request.name(),
                request.address(),
                request.qualityIndex(),
                request.openingHours()
        );
    }

    public UpdateFitnessDto toDto(FitnessRequest request) {
        return new UpdateFitnessDto(
                request.name(),
                request.address(),
                request.qualityIndex(),
                request.openingHours()
        );
    }
}
