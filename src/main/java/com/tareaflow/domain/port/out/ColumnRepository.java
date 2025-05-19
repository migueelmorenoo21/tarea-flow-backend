package com.tareaflow.domain.port.out;

import com.tareaflow.domain.model.Column;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ColumnRepository {
    Column save(Column column);
    List<Column> findByBoardId(UUID boardId);

    // Nuevo método para buscar una columna por su ID
    Optional<Column> findById(UUID columnId);
}
