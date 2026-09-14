package com.example.java_skill_project.domain.user;

import com.example.java_skill_project.domain.fitness.fitnessId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class user {
    @Setter(AccessLevel.NONE)
    private userId id;
    private String name;
    private String surname;
    private String email;
    private byte age;
    @Setter(AccessLevel.PRIVATE)
    private fitnessId fitnessId;
}
