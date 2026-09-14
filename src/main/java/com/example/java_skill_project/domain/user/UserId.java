package com.example.java_skill_project.domain.user;

import java.util.UUID;

public record UserId(UUID id) {
    private static UUID New(){
        return UUID.randomUUID();
    }
}
