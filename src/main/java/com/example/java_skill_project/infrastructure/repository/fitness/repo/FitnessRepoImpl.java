package com.example.java_skill_project.infrastructure.repository.fitness.repo;

import com.example.java_skill_project.domain.fitness.Fitness;
import com.example.java_skill_project.domain.fitness.FitnessId;
import com.example.java_skill_project.domain.fitness.FitnessRepo;
import com.example.java_skill_project.infrastructure.repository.fitness.entity.FitnessEntity;
import com.example.java_skill_project.infrastructure.repository.fitness.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FitnessRepoImpl implements FitnessRepo {

    private final JpaFitnessRepository repository;
    private final PersistenceMapper mapper;

    @Override
    public Optional<Fitness> findById(FitnessId id) {
        return repository.findById(id.id())
                .map(mapper::toDomain);
    }

    @Override
    public Fitness save(Fitness fitness) {
        FitnessEntity entity = mapper.toEntity(fitness);

        FitnessEntity savedEntity = repository.save(entity);

        return mapper.toDomain(savedEntity);
    }

    @Override
    public void delete(Fitness fitness) {
        repository.deleteById(fitness.getId().id());
    }
}
