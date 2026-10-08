package com.example.java_skill_project.domain.fitness;

import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.exception.InvalidFitnessNameException;
import com.example.java_skill_project.domain.shared.OpeningHours;
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
    private OpeningHours openingHours;

    public static Fitness reconstitute(
            FitnessId id,
            String name,
            Address address,
            OpeningHours openingHours,
            int quality
    ) {
        return new Fitness(
                id,
                name,
                address,
                quality,
                openingHours
        );
    }

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
        this.qualityIndex++;
    }

    public void decreaseQuality() {

        this.qualityIndex--;
    }
}

