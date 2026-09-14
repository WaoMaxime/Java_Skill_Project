package com.example.java_skill_project.domain.fitness;

import com.example.java_skill_project.domain.address.Address;
import com.example.java_skill_project.domain.exception.InvalidFitnessNameException;
import com.example.java_skill_project.domain.exception.InvalidQualitySetting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
@AggregateRoot
public class Fitness {
    private FitnessId id;
    private String name;
    private Address address;
    private int qualityIndex;
    private FitnessOpeningHours openingTime;
    private final FitnessProperties properties;

    public void rename(String newName) {
        if (Objects.isNull(newName) || newName.isBlank()) {
            throw new InvalidFitnessNameException(this.id);
        }
        this.name = newName;
    }

    public void relocate(Address newAddress) {
        this.address = newAddress;
    }

    public void increaseQuality() {
        if (this.qualityIndex < properties.maxQuality()) {
            throw new InvalidQualitySetting(this.id);
        }
        this.qualityIndex++;
    }

    public void decreaseQuality() {
        if (this.qualityIndex > properties.minQuality()) {
            throw new InvalidQualitySetting(this.id);
        }
        this.qualityIndex--;
    }
}

