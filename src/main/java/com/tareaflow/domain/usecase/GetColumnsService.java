package com.tareaflow.domain.usecase;

import com.tareaflow.domain.model.Column;
import com.tareaflow.domain.port.in.GetColumnsUseCase;
import com.tareaflow.domain.port.out.BoardAccessValidator;
import com.tareaflow.domain.port.out.ColumnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetColumnsService implements GetColumnsUseCase {

    private final ColumnRepository columnRepository;
    private final BoardAccessValidator boardAccessValidator;

    public GetColumnsService(ColumnRepository columnRepository,
                             BoardAccessValidator boardAccessValidator) {
        this.columnRepository = columnRepository;
        this.boardAccessValidator = boardAccessValidator;
    }

    @Override
    public List<Column> getColumnsByBoard(UUID boardId, UUID userId) {
        if (!boardAccessValidator.isMember(userId, boardId)
                && !boardAccessValidator.isOwner(userId, boardId)) {
            throw new IllegalStateException("El usuario no tiene acceso a este tablero");
        }
        return columnRepository.findByBoardId(boardId);
    }
}
