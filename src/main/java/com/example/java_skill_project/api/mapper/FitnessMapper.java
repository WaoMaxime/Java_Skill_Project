package com.example.java_skill_project.api.mapper;

import com.example.java_skill_project.api.mapper.response.AddressResponse;
import com.example.java_skill_project.api.mapper.response.OpeningHoursResponse;
import com.example.java_skill_project.api.mapper.response.FitnessResponse;
import com.example.java_skill_project.domain.address.Address;
import com.example.java_skill_project.domain.fitness.Fitness;
import com.example.java_skill_project.domain.fitness.FitnessOpeningHours;
import org.springframework.stereotype.Component;

@Component
public class FitnessMapper {
    public FitnessResponse toResponse(Fitness fitness) {
        return new FitnessResponse(
                fitness.getId().id(),
                fitness.getName(),
                toAddressResponse(fitness.getAddress()),
                fitness.getQualityIndex(),
                toOpeningHoursResponse(fitness.getFitnessOpeningHours())
        );
    }

    private AddressResponse toAddressResponse(Address address) {
        return new AddressResponse(
                address.street(),
                address.houseNumber(),
                address.postalCode(),
                address.province()
        );
    }

    private OpeningHoursResponse toOpeningHoursResponse(FitnessOpeningHours openingHours) {
        return new OpeningHoursResponse(
                openingHours.openingTime(),
                openingHours.closingTime()
        );
    }
}
