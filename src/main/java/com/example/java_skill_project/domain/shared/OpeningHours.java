package com.example.java_skill_project.domain.shared;

import com.example.java_skill_project.domain.exception.InvalidOpeningHoursException;
import org.jmolecules.ddd.annotation.ValueObject;
import java.time.LocalTime;
import java.util.Objects;

@ValueObject
public record OpeningHours(
        LocalTime openingTime,
        LocalTime closingTime
) {
    public OpeningHours {
        Objects.requireNonNull(openingTime);
        Objects.requireNonNull(closingTime);

        if (!openingTime.isBefore(closingTime)) {
            throw new InvalidOpeningHoursException();
        }
    }
}
