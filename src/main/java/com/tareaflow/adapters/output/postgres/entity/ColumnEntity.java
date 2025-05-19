package com.tareaflow.adapters.output.postgres.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "columns")
public class ColumnEntity {

    @Id
    private UUID id;

    private String name;
    private int position;

    @Column(name = "board_id")
    private UUID boardId;

    @Column(name = "created_at")
    private java.time.Instant createdAt;

    public ColumnEntity() {}

    public ColumnEntity(com.tareaflow.domain.model.Column domain) {
        this.id = domain.getId();
        this.name = domain.getName();
        this.position = domain.getPosition();
        this.boardId = domain.getBoardId();
        this.createdAt = java.time.Instant.now();
    }

    public com.tareaflow.domain.model.Column toDomain() {
        return new com.tareaflow.domain.model.Column(id, name, position, boardId);
    }

    // Getters & Setters omitted for brevity
}
