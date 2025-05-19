package com.tareaflow.adapters.output.postgres;

import com.tareaflow.adapters.output.postgres.entity.ColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataColumnRepository extends JpaRepository<ColumnEntity, UUID> {
    // Devuelve las columnas de un tablero ordenadas por su posición
    List<ColumnEntity> findByBoardIdOrderByPositionAsc(UUID boardId);
}
