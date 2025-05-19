package com.tareaflow.domain.usecase;

import com.tareaflow.adapters.input.rest.dto.CreateColumnRequest;
import com.tareaflow.domain.model.Column;
import com.tareaflow.domain.port.in.CreateColumnUseCase;
import com.tareaflow.domain.port.out.BoardAccessValidator;
import com.tareaflow.domain.port.out.ColumnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreateColumnService implements CreateColumnUseCase {

    private final ColumnRepository columnRepository;
    private final BoardAccessValidator boardAccessValidator;

    public CreateColumnService(ColumnRepository columnRepository,
                               BoardAccessValidator boardAccessValidator) {
        this.columnRepository = columnRepository;
        this.boardAccessValidator = boardAccessValidator;
    }

    @Override
    public Column createColumn(UUID boardId, CreateColumnRequest request, UUID userId) {
        if (!boardAccessValidator.isMember(userId, boardId)
                && !boardAccessValidator.isOwner(userId, boardId)) {
            throw new IllegalStateException("El usuario no tiene acceso a este tablero");
        }

        Column column = new Column(
                UUID.randomUUID(),
                request.getName(),
                request.getPosition(),
                boardId
        );
        return columnRepository.save(column);
    }
}
