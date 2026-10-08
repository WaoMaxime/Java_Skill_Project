package com.example.java_skill_project.infrastructure.repository.fitness.mapper;

import com.example.java_skill_project.domain.shared.Address;
import com.example.java_skill_project.domain.fitness.Fitness;
import com.example.java_skill_project.domain.fitness.FitnessId;
import com.example.java_skill_project.domain.shared.OpeningHours;
import com.example.java_skill_project.infrastructure.repository.fitness.entity.AddressEmbeddable;
import com.example.java_skill_project.infrastructure.repository.fitness.entity.FitnessEntity;
import com.example.java_skill_project.infrastructure.repository.fitness.entity.OpeningsHoursEmbeddable;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PersistenceMapper {

    public FitnessEntity toEntity(Fitness fitness) {
        return new FitnessEntity(
                fitness.getId().id(),
                fitness.getName(),
                toEmbeddable(fitness.getAddress()),
                fitness.getQualityIndex(),
                toEmbeddable(fitness.getOpeningHours())
        );
    }

    public Fitness toDomain(FitnessEntity entity) {
        return Fitness.reconstitute(
                FitnessId.from(entity.getId()),
                entity.getName(),
                toDomain(entity.getAddress()),
                toDomain(entity.getFitnessOpeningHours()),
                entity.getQualityIndex()
        );
    }

    private AddressEmbeddable toEmbeddable(Address address) {
        if (Objects.isNull(address)) {
            return null;
        }

        return new AddressEmbeddable(
                address.street(),
                address.houseNumber(),
                address.postalCode(),
                address.province()
        );
    }

    private Address toDomain(AddressEmbeddable address) {
        if (Objects.isNull(address)) {
            return null;
        }

        return new Address(
                address.getStreet(),
                address.getHouseNumber(),
                address.getPostalCode(),
                address.getProvince()
        );
    }

    private OpeningsHoursEmbeddable toEmbeddable(OpeningHours openingHours) {
        if (Objects.isNull(openingHours)) {
            return null;
        }

        return new OpeningsHoursEmbeddable(
                openingHours.openingTime(),
                openingHours.closingTime()
        );
    }

    private OpeningHours toDomain(OpeningsHoursEmbeddable openingHours) {
        if (Objects.isNull(openingHours)) {
            return null;
        }

        return new OpeningHours(
                openingHours.getOpeningTime(),
                openingHours.getClosingTime()
        );
    }
}
