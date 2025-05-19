package com.tareaflow.domain.port.in;

import com.tareaflow.domain.model.User;

import java.util.UUID;

public interface RegisterUserUseCase {
    User register(String name, String email, String rawPassword);

    // 🔧 AÑADIR ESTA LÍNEA:
    User getById(UUID id);
}
