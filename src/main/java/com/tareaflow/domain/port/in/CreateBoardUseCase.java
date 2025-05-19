package com.tareaflow.domain.port.in;

import com.tareaflow.domain.model.Board;

import java.util.UUID;

public interface CreateBoardUseCase {
    Board createBoard(UUID ownerId, String title, String description);
}
