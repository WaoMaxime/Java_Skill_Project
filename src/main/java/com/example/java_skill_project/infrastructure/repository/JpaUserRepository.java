package com.example.java_skill_project.infrastructure.repository;

import com.example.java_skill_project.domain.user.User;
import com.example.java_skill_project.domain.user.UserId;
import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends CrudRepository<User, UserId> {

}
