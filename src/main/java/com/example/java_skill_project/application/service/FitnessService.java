package com.example.java_skill_project.application.service;

import com.example.java_skill_project.api.mapper.request.CreateFitnessRequest;
import com.example.java_skill_project.api.mapper.request.FitnessRequest;
import com.example.java_skill_project.application.exception.FitnessNotFoundException;
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
    private final FitnessProperties fitnessProperties;

    public Fitness findFitnessById(UUID id) {
        return fitnessRepo.findById(FitnessId.from(id)).orElseThrow(() -> new FitnessNotFoundException(FitnessId.from(id)));
    }

    public Fitness create(CreateFitnessRequest request) {
        Fitness fitness = Fitness.builder()
                .name(request.name())
                .address(request.address())
                .fitnessOpeningHours(request.openingHours())
                .qualityIndex(request.qualityIndex())
                .build();

        return fitnessRepo.save(fitness);
    }

    public Fitness update(UUID id, FitnessRequest request) {
        FitnessId fitnessId = FitnessId.from(id);

        Fitness fitness = fitnessRepo.findById(fitnessId)
                .orElseThrow(() -> new FitnessNotFoundException(fitnessId));

        if (Objects.nonNull(request.name()))  {
            fitness.rename(request.name());
        }

        if (Objects.nonNull(request.address())) {
            fitness.relocate(request.address());
        }

        if (Objects.nonNull(request.qualityIndex())) {
            switch (request.qualityIndex()) {
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

        return fitnessRepo.save(fitness);
    }

    public void delete(UUID id) {
        FitnessId fitnessId = FitnessId.from(id);

        Fitness fitness = fitnessRepo.findById(fitnessId)
                .orElseThrow(() -> new FitnessNotFoundException(fitnessId));

        fitnessRepo.delete(fitness);
    }
}
