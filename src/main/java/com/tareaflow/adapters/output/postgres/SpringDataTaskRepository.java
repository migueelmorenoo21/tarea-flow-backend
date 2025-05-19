package com.tareaflow.adapters.output.postgres;

import com.tareaflow.adapters.output.postgres.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataTaskRepository extends JpaRepository<TaskEntity, UUID> {

    /**
     * Devuelve las tareas de una columna ordenadas por posición ascendente.
     */
    List<TaskEntity> findByColumnIdOrderByPositionAsc(UUID columnId);
}
