package com.example.java_skill_project.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FitnessQualityValidator.class)
public @interface ValidFitnessQuality {

    String message() default "Invalid fitness quality index";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
