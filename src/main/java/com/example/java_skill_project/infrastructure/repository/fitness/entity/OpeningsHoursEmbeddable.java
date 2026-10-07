package com.example.java_skill_project.infrastructure.repository.fitness.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpeningsHoursEmbeddable {
    private LocalTime openingTime;
    private LocalTime closingTime;
}
