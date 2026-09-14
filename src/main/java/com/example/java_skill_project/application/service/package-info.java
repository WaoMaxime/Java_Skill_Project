@ApplicationModule(
        allowedDependencies = {
                "application::exception",
                "domain::address",
                "domain::fitness",
                "domain::user"
        }
)
@NamedInterface("service")
package com.example.java_skill_project.application.service;

import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.NamedInterface;