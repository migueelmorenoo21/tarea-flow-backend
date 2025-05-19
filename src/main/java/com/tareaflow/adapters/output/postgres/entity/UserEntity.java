package com.tareaflow.adapters.output.postgres.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "is_company")
    private boolean isCompany;

    private String plan;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public UserEntity() {}

    // === Getters ===
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isCompany() {
        return isCompany;
    }

    public String getPlan() {
        return plan;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // === Setters ===
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setCompany(boolean isCompany) {
        this.isCompany = isCompany;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
