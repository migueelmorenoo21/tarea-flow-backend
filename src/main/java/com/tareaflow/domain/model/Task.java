package com.tareaflow.domain.model;

import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private String description;
    private UUID boardId;
    private UUID columnId;
    private UUID assignedTo;
    private int position;
    private boolean isCompleted;

    public Task(UUID id, String title, String description, UUID boardId, UUID columnId,
                UUID assignedTo, int position, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.boardId = boardId;
        this.columnId = columnId;
        this.assignedTo = assignedTo;
        this.position = position;
        this.isCompleted = isCompleted;
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

    public UUID getBoardId() {
        return boardId;
    }

    public UUID getColumnId() {
        return columnId;
    }

    public UUID getAssignedTo() {
        return assignedTo;
    }

    public int getPosition() {
        return position;
    }

    public boolean isCompleted() {
        return isCompleted;
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

    public void setBoardId(UUID boardId) {
        this.boardId = boardId;
    }

    public void setColumnId(UUID columnId) {
        this.columnId = columnId;
    }

    public void setAssignedTo(UUID assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
