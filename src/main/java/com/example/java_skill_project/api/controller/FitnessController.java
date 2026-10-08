package com.example.java_skill_project.api.controller;

import com.example.java_skill_project.api.mapper.FitnessApiMapper;
import com.example.java_skill_project.api.request.CreateFitnessRequest;
import com.example.java_skill_project.api.request.FitnessRequest;
import com.example.java_skill_project.api.response.FitnessResponse;
import com.example.java_skill_project.application.dto.FitnessDto;
import com.example.java_skill_project.application.service.FitnessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/${version}/fitness")
@RestController
public class FitnessController {

    private final FitnessService fitnessService;
    private final FitnessApiMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<FitnessResponse> getById(@PathVariable UUID id) {
        FitnessDto fitness = fitnessService.findFitnessById(id);
        return ResponseEntity.ok(mapper.toResponse(fitness));
    }

    @GetMapping
    public ResponseEntity<List<FitnessResponse>> getAll() {
        List<FitnessResponse> fitnesses = fitnessService.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(fitnesses);
    }

    @PostMapping
    public ResponseEntity<FitnessResponse> create(@Valid @RequestBody CreateFitnessRequest request) {
        FitnessDto fitness = fitnessService.create(mapper.toDto(request));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(fitness));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FitnessResponse> update(@PathVariable UUID id, @RequestBody FitnessRequest request) {
        FitnessDto fitness = fitnessService.update(id, mapper.toDto(request));
        return ResponseEntity.ok(mapper.toResponse(fitness));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        fitnessService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
