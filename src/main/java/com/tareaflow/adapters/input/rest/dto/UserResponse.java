package com.tareaflow.adapters.input.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserResponse {
    public UUID id;
    public String name;
    public String email;
    public boolean isCompany;
    public String plan;
    public LocalDateTime createdAt;

    public UserResponse(UUID id, String name, String email, boolean isCompany, String plan, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isCompany = isCompany;
        this.plan = plan;
        this.createdAt = createdAt;
    }
}
