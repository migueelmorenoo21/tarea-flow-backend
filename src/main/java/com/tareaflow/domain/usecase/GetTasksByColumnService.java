package com.tareaflow.domain.usecase;

import com.tareaflow.domain.model.Task;
import com.tareaflow.domain.port.in.GetTasksByColumnUseCase;
import com.tareaflow.domain.port.out.BoardAccessValidator;
import com.tareaflow.domain.port.out.TaskRepository;
import com.tareaflow.domain.port.out.ColumnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetTasksByColumnService implements GetTasksByColumnUseCase {

    private final TaskRepository taskRepository;
    private final ColumnRepository columnRepository;
    private final BoardAccessValidator boardAccessValidator;

    public GetTasksByColumnService(
            TaskRepository taskRepository,
            ColumnRepository columnRepository,
            BoardAccessValidator boardAccessValidator
    ) {
        this.taskRepository = taskRepository;
        this.columnRepository = columnRepository;
        this.boardAccessValidator = boardAccessValidator;
    }

    @Override
    public List<Task> getTasksByColumn(UUID columnId, UUID userId) {
        // 1) Obtener la columna para extraer su boardId
        com.tareaflow.domain.model.Column column =
                columnRepository.findById(columnId)
                        .orElseThrow(() -> new IllegalArgumentException("Columna no encontrada"));

        UUID boardId = column.getBoardId();

        // 2) Validar acceso (miembro u owner)
        boolean isMember = boardAccessValidator.isMember(userId, boardId);
        boolean isOwner  = boardAccessValidator.isOwner(userId, boardId);
        if (!isMember && !isOwner) {
            throw new IllegalStateException("El usuario no tiene acceso a este tablero");
        }

        // 3) Listar y devolver tareas
        return taskRepository.findByColumnId(columnId);
    }
}
