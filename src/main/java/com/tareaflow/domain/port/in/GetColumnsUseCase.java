package com.tareaflow.domain.port.in;

import com.tareaflow.domain.model.Column;

import java.util.List;
import java.util.UUID;

public interface GetColumnsUseCase {
    List<Column> getColumnsByBoard(UUID boardId, UUID userId);
}
