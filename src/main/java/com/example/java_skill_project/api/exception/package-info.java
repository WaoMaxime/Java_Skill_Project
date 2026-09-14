@ApplicationModule(
        allowedDependencies = {
           "application::exception",
                "domain::exception"
        }
)
package com.example.java_skill_project.api.exception;
import org.springframework.modulith.ApplicationModule;