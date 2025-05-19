package com.tareaflow.adapters.input.rest.dto;

import java.util.UUID;

public class CreateTaskRequest {
    private String title;
    private String description;
    private UUID boardId;
    private UUID columnId;
    private UUID assignedTo;
    private int position;

    // Constructor vacío para deserialización
    public CreateTaskRequest() {}

    public CreateTaskRequest(String title, String description, UUID boardId, UUID columnId, UUID assignedTo, int position) {
        this.title = title;
        this.description = description;
        this.boardId = boardId;
        this.columnId = columnId;
        this.assignedTo = assignedTo;
        this.position = position;
    }

    // === GETTERS ===

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

    // === SETTERS ===

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
}
