package com.example.java_skill_project.infrastructure.repository.fitness.repo;

import com.example.java_skill_project.infrastructure.repository.fitness.entity.FitnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaFitnessRepository extends JpaRepository<FitnessEntity, UUID> {

}
