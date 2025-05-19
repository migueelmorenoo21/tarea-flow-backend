package com.tareaflow.adapters.input.rest;

import com.tareaflow.adapters.input.rest.dto.LoginRequest;
import com.tareaflow.adapters.input.rest.dto.LoginResponse;
import com.tareaflow.domain.port.in.LoginUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final LoginUserUseCase loginUserUseCase;

    public AuthController(LoginUserUseCase loginUserUseCase) {
        this.loginUserUseCase = loginUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = loginUserUseCase.login(request.email, request.password);
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
