package com.example.java_skill_project.api.mapper.response;

public record AddressResponse (
        String street,
        String houseNumber,
        String postalCode,
        String province
) {}