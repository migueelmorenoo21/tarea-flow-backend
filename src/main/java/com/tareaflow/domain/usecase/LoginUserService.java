package com.tareaflow.domain.usecase;

import com.tareaflow.domain.model.User;
import com.tareaflow.domain.port.in.LoginUserUseCase;
import com.tareaflow.domain.port.out.UserRepository;
import com.tareaflow.security.JwtProvider;
import com.tareaflow.security.PasswordHasher;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements LoginUserUseCase {

    private final UserRepository userRepository;

    public LoginUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(String email, String rawPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String hashed = PasswordHasher.hash(rawPassword);
        if (!hashed.equals(user.getPasswordHash())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return JwtProvider.generateToken(user.getId(), user.getEmail());
    }
}
