package com.tareaflow.domain.port.in;

import com.tareaflow.adapters.input.rest.dto.CreateColumnRequest;
import com.tareaflow.domain.model.Column;

import java.util.UUID;

public interface CreateColumnUseCase {
    Column createColumn(UUID boardId, CreateColumnRequest request, UUID userId);
}
