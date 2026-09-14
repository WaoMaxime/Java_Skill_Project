package com.example.java_skill_project.domain.fitness;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FitnessRepo {
    Optional<Fitness> findById(FitnessId id);

    Fitness save(Fitness fitness);

    void delete(Fitness fitness);
}
