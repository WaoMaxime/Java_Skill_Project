package com.example.java_skill_project.domain.user;

import java.util.Optional;

public interface UserRepo {
    Optional<User> findById(UserId id);

    User save(User user);

    void delete(User user);
}
