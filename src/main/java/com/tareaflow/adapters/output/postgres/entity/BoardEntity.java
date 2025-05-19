package com.tareaflow.adapters.output.postgres.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "boards")
public class BoardEntity {

    @Id
    private UUID id;

    private String title;

    private String description;

    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "created_at")
    private Instant createdAt;

    public BoardEntity() {
    }

    // === GETTERS ===
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    // === SETTERS ===
    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
