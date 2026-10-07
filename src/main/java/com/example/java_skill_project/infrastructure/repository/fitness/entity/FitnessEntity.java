package com.example.java_skill_project.infrastructure.repository.fitness.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "fitness")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FitnessEntity {

    @Id
    private UUID id;

    private String name;

    @Embedded
    private AddressEmbeddable address;

    private int qualityIndex;

    @Embedded
    private OpeningsHoursEmbeddable fitnessOpeningHours;

}
