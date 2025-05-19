package com.tareaflow.domain.port.in;

public interface LoginUserUseCase {
    String login(String email, String rawPassword);
}
