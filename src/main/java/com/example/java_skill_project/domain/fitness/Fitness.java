package com.example.java_skill_project.domain.fitness;

import com.example.java_skill_project.domain.exception.InvalidQualitySettingException;
import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.exception.InvalidFitnessNameException;
import com.example.java_skill_project.domain.shared.OpeningHours;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.util.Objects;

@Getter
@AggregateRoot
public class Fitness {
    private final FitnessId id;
    private String name;
    private Address address;
    private int qualityIndex;
    private OpeningHours openingHours;

    private Fitness(
            FitnessId id,
            String name,
            Address address,
            int qualityIndex,
            OpeningHours openingHours
    ) {
        this.id = Objects.requireNonNull(id);
        this.name = validateName(name);
        this.address = Objects.requireNonNull(address);
        this.qualityIndex = qualityIndex;
        this.openingHours =
                Objects.requireNonNull(openingHours);
    }

    public static Fitness create(
            String name,
            Address address,
            OpeningHours openingHours,
            int qualityIndex,
            QualityRange range
    ) {
        validateQuality(qualityIndex, range);

        return new Fitness(
                FitnessId.New(),
                name,
                address,
                qualityIndex,
                openingHours
        );
    }

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
            throw new InvalidFitnessNameException();
        }
        this.name = newName;
    }

    public void relocate(Address newAddress) {
        this.address = newAddress;
    }

    public void changeOpeningHours(OpeningHours hours) {
        this.openingHours = Objects.requireNonNull(hours);
    }

    public void increaseQuality(QualityRange range) {
        changeQuality(1, range);
    }

    public void decreaseQuality(QualityRange range) {
        changeQuality(-1, range);
    }

    private void changeQuality(int delta, QualityRange range) {
        int newQuality = Math.addExact(qualityIndex, delta);
        validateQuality(newQuality, range);
        this.qualityIndex = newQuality;
    }

    private static void validateQuality(
            int quality,
            QualityRange range
    ) {
        if (!Objects.requireNonNull(range).contains(quality)) {
            throw new InvalidQualitySettingException();
        }
    }

    private static String validateName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new InvalidFitnessNameException();
        }
        return name;
    }
}

