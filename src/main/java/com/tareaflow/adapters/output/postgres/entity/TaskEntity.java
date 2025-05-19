package com.tareaflow.adapters.output.postgres.entity;

import com.tareaflow.domain.model.Task;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    private UUID id;

    private String title;
    private String description;

    @Column(name = "board_id")
    private UUID boardId;

    @Column(name = "column_id")
    private UUID columnId;

    @Column(name = "assigned_to")
    private UUID assignedTo;

    private int position;

    @Column(name = "is_completed")
    private boolean isCompleted;

    // Constructor vacío (obligatorio para JPA)
    public TaskEntity() {}

    // Constructor desde dominio
    public TaskEntity(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.boardId = task.getBoardId();
        this.columnId = task.getColumnId();
        this.assignedTo = task.getAssignedTo();
        this.position = task.getPosition();
        this.isCompleted = task.isCompleted();
    }

    // Conversión a objeto del dominio
    public Task toDomain() {
        return new Task(
                this.id,
                this.title,
                this.description,
                this.boardId,
                this.columnId,
                this.assignedTo,
                this.position,
                this.isCompleted
        );
    }

    // === GETTERS & SETTERS ===

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getBoardId() {
        return boardId;
    }

    public void setBoardId(UUID boardId) {
        this.boardId = boardId;
    }

    public UUID getColumnId() {
        return columnId;
    }

    public void setColumnId(UUID columnId) {
        this.columnId = columnId;
    }

    public UUID getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UUID assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

