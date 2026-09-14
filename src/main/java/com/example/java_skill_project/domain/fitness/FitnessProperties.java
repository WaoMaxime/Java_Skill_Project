package com.example.java_skill_project.domain.fitness;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.LocalTime;

@ConfigurationProperties(prefix = "fitness")
public record FitnessProperties(int maxQuality,
                                int minQuality) {
}
