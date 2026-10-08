package com.example.java_skill_project.application.service;

import com.example.java_skill_project.application.dto.CreateFitnessDto;
import com.example.java_skill_project.application.dto.FitnessDto;
import com.example.java_skill_project.application.dto.UpdateFitnessDto;
import com.example.java_skill_project.application.exception.FitnessNotFoundException;
import com.example.java_skill_project.application.mapper.FitnessDtoMapper;
import com.example.java_skill_project.application.properties.FitnessProperties;
import com.example.java_skill_project.domain.fitness.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FitnessService {

    private final FitnessRepo fitnessRepo;
    private final FitnessDtoMapper mapper;
    private final FitnessProperties fitnessProperties;

    private QualityRange qualityRange() {
        return new QualityRange(
                fitnessProperties.minQuality(),
                fitnessProperties.maxQuality()
        );
    }

    @Transactional
    public FitnessDto findFitnessById(UUID id) {
        Fitness fitness = fitnessRepo.findById(FitnessId.from(id)).orElseThrow(() -> new FitnessNotFoundException(FitnessId.from(id)));
        return mapper.toFitnessDto(fitness);
    }

    @Transactional
    public List<FitnessDto> findAll() {
        return fitnessRepo.findAll()
                .stream()
                .map(mapper::toFitnessDto)
                .toList();
    }

    @Transactional
    public FitnessDto create(CreateFitnessDto dto) {
        Fitness fitness = Fitness.create(
                dto.name(),
                dto.address(),
                dto.openingHours(),
                dto.qualityIndex(),
                qualityRange()
        );

        fitnessRepo.save(fitness);

        return mapper.toFitnessDto(fitness);
    }

    @Transactional
    public FitnessDto update(UUID id, UpdateFitnessDto dto) {
        FitnessId fitnessId = FitnessId.from(id);

        Fitness fitness = fitnessRepo.findById(fitnessId)
                .orElseThrow(() -> new FitnessNotFoundException(fitnessId));

        if (dto.name() != null) {
            fitness.rename(dto.name());
        }

        if (dto.address() != null) {
            fitness.relocate(dto.address());
        }

        if (dto.openingHours() != null) {
            fitness.changeOpeningHours(dto.openingHours());
        }

        if (dto.qualityIndex() != null) {
            switch (dto.qualityIndex()) {
                case INCREASE -> fitness.increaseQuality(qualityRange());
                case DECREASE -> fitness.decreaseQuality(qualityRange());
            }
        }

        Fitness savedFitness = fitnessRepo.save(fitness);

        return mapper.toFitnessDto(savedFitness);
    }

    @Transactional
    public void delete(UUID id) {
        FitnessId fitnessId = FitnessId.from(id);

        Fitness fitness = fitnessRepo.findById(fitnessId)
                .orElseThrow(() -> new FitnessNotFoundException(fitnessId));

        fitnessRepo.delete(fitness);
    }
}
