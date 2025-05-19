package com.tareaflow.adapters.output.postgres;

import com.tareaflow.adapters.output.postgres.entity.TaskEntity;
import com.tareaflow.domain.model.Task;
import com.tareaflow.domain.port.out.TaskRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TaskRepositoryAdapter implements TaskRepository {

    private final SpringDataTaskRepository jpaRepository;

    public TaskRepositoryAdapter(SpringDataTaskRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity entity = new TaskEntity(task);
        return jpaRepository.save(entity).toDomain();
    }

    @Override
    public List<Task> findByColumnId(UUID columnId) {
        return jpaRepository
                .findByColumnIdOrderByPositionAsc(columnId)
                .stream()
                .map(TaskEntity::toDomain)
                .collect(Collectors.toList());
    }
}
