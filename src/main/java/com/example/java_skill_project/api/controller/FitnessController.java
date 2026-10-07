package com.example.java_skill_project.api.controller;

import com.example.java_skill_project.api.mapper.FitnessMapper;
import com.example.java_skill_project.api.mapper.request.CreateFitnessRequest;
import com.example.java_skill_project.api.mapper.request.FitnessRequest;
import com.example.java_skill_project.api.mapper.response.FitnessResponse;
import com.example.java_skill_project.application.service.FitnessService;
import com.example.java_skill_project.domain.fitness.Fitness;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/${version}/fitness")
@RestController
public class FitnessController {

    private final FitnessService fitnessService;
    private final FitnessMapper fitnessMapper;

    @GetMapping("/{id}")
    public ResponseEntity<FitnessResponse> getById(@PathVariable UUID id) {
        Fitness fitness = fitnessService.findFitnessById(id);
        return ResponseEntity.ok(fitnessMapper.toResponse(fitness));
    }

    @PostMapping
    public ResponseEntity<FitnessResponse> create(@Valid @RequestBody CreateFitnessRequest request) {
        Fitness fitness = fitnessService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(fitnessMapper.toResponse(fitness));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FitnessResponse> update(@PathVariable UUID id, @RequestBody FitnessRequest request) {
        Fitness fitness = fitnessService.update(id, request);
        return ResponseEntity.ok(fitnessMapper.toResponse(fitness));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        fitnessService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
