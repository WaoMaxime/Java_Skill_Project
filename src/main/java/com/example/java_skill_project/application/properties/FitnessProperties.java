package com.example.java_skill_project.application.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fitness.quality")
public record FitnessProperties(
        int maxQuality,
        int minQuality
) {}
