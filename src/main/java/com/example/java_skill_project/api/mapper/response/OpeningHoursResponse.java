package com.example.java_skill_project.api.mapper.response;

import java.time.LocalTime;

public record OpeningHoursResponse(
        LocalTime openingTime,
        LocalTime closingTime
) {}
