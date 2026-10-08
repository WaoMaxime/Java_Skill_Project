package com.example.java_skill_project.domain.exception;

public class InvalidQualitySettingException extends RuntimeException {
    public InvalidQualitySettingException() {
        super("Invalid quality setting for fitness");
    }
}
