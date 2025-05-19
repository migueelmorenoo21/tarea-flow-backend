package com.tareaflow.domain.usecase;

import com.tareaflow.domain.model.User;
import com.tareaflow.domain.port.in.RegisterUserUseCase;
import com.tareaflow.domain.port.out.UserRepository;
import com.tareaflow.security.PasswordHasher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String name, String email, String rawPassword) {
        // Hash manual de contraseña usando clase personalizada
        String passwordHash = PasswordHasher.hash(rawPassword);

        User newUser = new User(
                UUID.randomUUID(),
                name,
                email,
                passwordHash,
                false,
                "free",
                LocalDateTime.now()
        );

        return userRepository.save(newUser);
    }

    @Override
    public User getById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
