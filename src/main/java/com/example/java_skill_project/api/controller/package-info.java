@ApplicationModule(
        allowedDependencies = {"application::service", "api :: request", "api :: response", "application.service"}
)
package com.example.java_skill_project.api.controller;
import org.springframework.modulith.ApplicationModule;