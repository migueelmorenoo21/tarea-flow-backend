package com.tareaflow.domain.model;

import java.util.UUID;

public class Column {
    private UUID id;
    private String name;
    private int position;
    private UUID boardId;

    public Column(UUID id, String name, int position, UUID boardId) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.boardId = boardId;
    }

    // Getters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public int getPosition() { return position; }
    public UUID getBoardId() { return boardId; }

    // Setters
    public void setId(UUID id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPosition(int position) { this.position = position; }
    public void setBoardId(UUID boardId) { this.boardId = boardId; }
}
