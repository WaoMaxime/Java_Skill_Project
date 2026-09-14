package com.example.java_skill_project.domain.user;

import com.example.java_skill_project.domain.fitness.FitnessId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.ddd.annotation.Entity;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Setter(AccessLevel.NONE)
    private UserId id;
    private String name;
    private String surname;
    private String email;
    private byte age;
    @Setter(AccessLevel.PRIVATE)
    private FitnessId fitnessId;
}
