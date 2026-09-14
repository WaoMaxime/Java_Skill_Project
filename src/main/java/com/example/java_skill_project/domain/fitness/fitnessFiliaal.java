package com.example.java_skill_project.domain.fitness;

import com.example.java_skill_project.domain.adres;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class fitnessFiliaal {
    @Setter(AccessLevel.NONE)
    private fitnessId id;
    private String naam;
    private adres adres;
    private int qualityIndex;
}

