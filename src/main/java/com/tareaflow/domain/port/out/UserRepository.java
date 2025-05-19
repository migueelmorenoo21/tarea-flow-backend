package com.tareaflow.domain.port.out;

import com.tareaflow.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    Optional<User> findById(UUID id);

    User save(User user);
}
