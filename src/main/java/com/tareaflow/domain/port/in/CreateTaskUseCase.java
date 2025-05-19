package com.tareaflow.domain.port.in;

import com.tareaflow.adapters.input.rest.dto.CreateTaskRequest;
import com.tareaflow.domain.model.Task;

import java.util.UUID;

public interface CreateTaskUseCase {
    Task createTask(CreateTaskRequest request, UUID userId);
}
