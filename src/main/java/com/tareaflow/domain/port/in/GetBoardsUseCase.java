package com.tareaflow.domain.port.in;

import com.tareaflow.domain.model.Board;

import java.util.List;
import java.util.UUID;

public interface GetBoardsUseCase {
    List<Board> getBoardsForUser(UUID userId);
}
