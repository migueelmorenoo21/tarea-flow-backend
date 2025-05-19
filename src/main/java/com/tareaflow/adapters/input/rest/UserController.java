package com.tareaflow.adapters.input.rest;

import com.tareaflow.adapters.input.rest.dto.RegisterUserRequest;
import com.tareaflow.adapters.input.rest.dto.UserResponse;
import com.tareaflow.domain.model.User;
import com.tareaflow.domain.port.in.RegisterUserUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

    public UserController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    // Endpoint para registrar usuario
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterUserRequest request) {
        User user = registerUserUseCase.register(
                request.name,
                request.email,
                request.password
        );

        return ResponseEntity.ok(new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.isCompany(),
                user.getPlan(),
                user.getCreatedAt()
        ));
    }

    // Endpoint protegido que devuelve el usuario autenticado
    @GetMapping("/me")
    public ResponseEntity<UserResponse> getMyUser(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(401).build();
        }

        UUID id = UUID.fromString(userId);
        User user = registerUserUseCase.getById(id); // se puede mover a su propio useCase en el futuro

        return ResponseEntity.ok(new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.isCompany(),
                user.getPlan(),
                user.getCreatedAt()
        ));
    }
}
