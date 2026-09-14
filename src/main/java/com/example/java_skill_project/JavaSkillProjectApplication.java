package com.example.java_skill_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JavaSkillProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSkillProjectApplication.class, args);
    }

}
