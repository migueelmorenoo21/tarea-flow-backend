package com.tareaflow.adapters.input.rest.dto;

import com.tareaflow.domain.model.Board;

import java.time.LocalDateTime;
import java.util.UUID;

public class BoardResponse {
    public UUID id;
    public String title;
    public String description;
    public UUID ownerId;
    public LocalDateTime createdAt;

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.description = board.getDescription();
        this.ownerId = board.getOwnerId();
        this.createdAt = board.getCreatedAt();
    }
}