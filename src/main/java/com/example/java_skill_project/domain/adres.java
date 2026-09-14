package com.example.java_skill_project.domain;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record adres(
        String straat,
        String huisnummer,
        String postcode,
        String plaats) {
}
