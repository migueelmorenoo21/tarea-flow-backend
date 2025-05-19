package com.tareaflow.domain.usecase;

import com.tareaflow.adapters.input.rest.dto.CreateTaskRequest;
import com.tareaflow.domain.model.Task;
import com.tareaflow.domain.port.in.CreateTaskUseCase;
import com.tareaflow.domain.port.out.BoardAccessValidator;
import com.tareaflow.domain.port.out.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepository taskRepository;
    private final BoardAccessValidator boardAccessValidator;

    public CreateTaskService(TaskRepository taskRepository, BoardAccessValidator boardAccessValidator) {
        this.taskRepository = taskRepository;
        this.boardAccessValidator = boardAccessValidator;
    }

    @Override
    public Task createTask(CreateTaskRequest request, UUID userId) {
        UUID boardId = request.getBoardId();

        // ✅ Comprobación combinada: miembro o propietario
        boolean isMember = boardAccessValidator.isMember(userId, boardId);
        boolean isOwner = boardAccessValidator.isOwner(userId, boardId);

        if (!isMember && !isOwner) {
            throw new IllegalStateException("El usuario no tiene acceso a este tablero");
        }

        Task task = new Task(
                UUID.randomUUID(),
                request.getTitle(),
                request.getDescription(),
                boardId,
                request.getColumnId(),
                request.getAssignedTo(),
                request.getPosition(),
                false // isCompleted
        );

        return taskRepository.save(task);
    }
}
