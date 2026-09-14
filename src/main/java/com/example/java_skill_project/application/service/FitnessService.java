package com.example.java_skill_project.application.service;

import com.example.java_skill_project.application.exception.FitnessNotFoundException;
import com.example.java_skill_project.domain.address.Address;
import com.example.java_skill_project.domain.fitness.Fitness;
import com.example.java_skill_project.domain.fitness.FitnessRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FitnessService {

    private final FitnessRepo fitnessRepo;

    public Fitness findFitnessById(UUID id) {
        return fitnessRepo.findById(id).orElseThrow(() -> new FitnessNotFoundException(id));;
    }

    public Fitness rename(String newName, UUID id) {
        Fitness fitness = fitnessRepo.findById(id).orElseThrow(() -> new FitnessNotFoundException(id));
        fitness.rename(newName);
        return fitnessRepo.save(fitness);
    }

    public Fitness relocate(Address newAddress, UUID id) {
        Fitness fitness = fitnessRepo.findById(id).orElseThrow(() -> new FitnessNotFoundException(id));
        fitness.relocate(newAddress);
        return fitnessRepo.save(fitness);
    }

    public Fitness increaseQuality(UUID id) {
        Fitness fitness = fitnessRepo.findById(id).orElseThrow(() -> new FitnessNotFoundException(id));
        fitness.increaseQuality();
        return fitnessRepo.save(fitness);
    }

    public Fitness decreaseQuality(UUID id) {
        Fitness fitness = fitnessRepo.findById(id).orElseThrow(() -> new FitnessNotFoundException(id));
        fitness.decreaseQuality();
        return fitnessRepo.save(fitness);
    }
}
