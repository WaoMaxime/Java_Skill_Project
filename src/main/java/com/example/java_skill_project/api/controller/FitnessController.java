package com.example.java_skill_project.api.controller;

import com.example.java_skill_project.api.mapper.response.FitnessResponse;
import com.example.java_skill_project.application.service.FitnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class FitnessController {

    private final FitnessService fitnessService;

    @GetMapping("/{id}")
    public ResponseEntity<FitnessResponse> getFitness(@PathVariable UUID id) {
        return fitnessService.findFitnessById(id);
    }

}
