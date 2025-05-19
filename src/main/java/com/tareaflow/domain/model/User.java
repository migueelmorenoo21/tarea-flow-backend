package com.tareaflow.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String passwordHash;
    private boolean isCompany;
    private String plan;
    private LocalDateTime createdAt;

    public User() {}

    public User(UUID id, String name, String email, String passwordHash, boolean isCompany, String plan, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.isCompany = isCompany;
        this.plan = plan;
        this.createdAt = createdAt;
    }

    // Getters y Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public boolean isCompany() { return isCompany; }
    public void setCompany(boolean company) { isCompany = company; }

    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
