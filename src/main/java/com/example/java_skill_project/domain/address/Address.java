package com.example.java_skill_project.domain.address;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Address(
        String street,
        String houseNumber,
        String postalCode,
        String province) {
}
