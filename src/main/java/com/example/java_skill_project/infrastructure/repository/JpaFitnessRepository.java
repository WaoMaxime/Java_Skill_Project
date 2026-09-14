package com.example.java_skill_project.infrastructure.repository;

import com.example.java_skill_project.domain.fitness.Fitness;
import com.example.java_skill_project.domain.fitness.FitnessId;
import org.springframework.data.repository.CrudRepository;

public interface JpaFitnessRepository extends CrudRepository<Fitness, FitnessId> {

}
