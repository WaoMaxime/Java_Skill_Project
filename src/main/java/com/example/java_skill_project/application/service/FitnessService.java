package com.example.java_skill_project.application.service;

import com.example.java_skill_project.application.dto.CreateFitnessDto;
import com.example.java_skill_project.application.dto.FitnessDto;
import com.example.java_skill_project.application.dto.UpdateFitnessDto;
import com.example.java_skill_project.application.exception.FitnessNotFoundException;
import com.example.java_skill_project.application.mapper.FitnessDtoMapper;
import com.example.java_skill_project.domain.fitness.Fitness;
import com.example.java_skill_project.domain.fitness.FitnessId;
import com.example.java_skill_project.domain.fitness.FitnessProperties;
import com.example.java_skill_project.domain.fitness.FitnessRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FitnessService {

    private final FitnessRepo fitnessRepo;
    private final FitnessDtoMapper mapper;
    private final FitnessProperties fitnessProperties;

    public FitnessDto findFitnessById(UUID id) {
        Fitness fitness = fitnessRepo.findById(FitnessId.from(id)).orElseThrow(() -> new FitnessNotFoundException(FitnessId.from(id)));
        return mapper.toFitnessDto(fitness);
    }

    public FitnessDto create(CreateFitnessDto dto) {
        Fitness fitness = Fitness.builder()
                .id(FitnessId.New())
                .name(dto.name())
                .address(dto.address())
                .openingHours(dto.openingHours())
                .qualityIndex(dto.qualityIndex())
                .build();

        fitnessRepo.save(fitness);

        return mapper.toFitnessDto(fitness);
    }

    public FitnessDto update(UUID id, UpdateFitnessDto dto) {
        FitnessId fitnessId = FitnessId.from(id);

        Fitness fitness = fitnessRepo.findById(fitnessId)
                .orElseThrow(() -> new FitnessNotFoundException(fitnessId));

        if (Objects.nonNull(dto.name()))  {
            fitness.rename(dto.name());
        }

        if (Objects.nonNull(dto.address())) {
            fitness.relocate(dto.address());
        }

        if (Objects.nonNull(dto.qualityIndex())) {
            switch (dto.qualityIndex()) {
                case INCREASE -> {
                    if (fitness.getQualityIndex() < fitnessProperties.maxQuality()) {
                        fitness.increaseQuality();
                    }
                }

                case DECREASE -> {
                    if (fitness.getQualityIndex() > fitnessProperties.minQuality()) {
                        fitness.decreaseQuality();
                    }
                }
            }
        }

        fitnessRepo.save(fitness);

        return mapper.toFitnessDto(fitness);
    }

    public void delete(UUID id) {
        FitnessId fitnessId = FitnessId.from(id);

        Fitness fitness = fitnessRepo.findById(fitnessId)
                .orElseThrow(() -> new FitnessNotFoundException(fitnessId));

        fitnessRepo.delete(fitness);
    }
}
