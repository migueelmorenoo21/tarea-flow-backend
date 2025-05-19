package com.tareaflow.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Board {
    private UUID id;
    private String title;
    private String description;
    private UUID ownerId;
    private LocalDateTime createdAt;

    // Constructor vacío
    public Board() {}

    public Board(UUID id, String title, String description, UUID ownerId, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
        this.createdAt = createdAt;
    }

    // Getters y Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UUID getOwnerId() { return ownerId; }
    public void setOwnerId(UUID ownerId) { this.ownerId = ownerId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
