package com.tareaflow.domain.port.out;

import com.tareaflow.domain.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findByColumnId(UUID columnId);

}