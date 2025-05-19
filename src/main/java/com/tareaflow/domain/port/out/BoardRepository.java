package com.tareaflow.domain.port.out;

import com.tareaflow.domain.model.Board;

import java.util.List;
import java.util.UUID;

public interface BoardRepository {
    List<Board> findAllByUserId(UUID userId);

    Board save(Board board);
}
