package com.tareaflow.domain.port.in;

import com.tareaflow.domain.model.Task;

import java.util.List;
import java.util.UUID;

public interface GetTasksByColumnUseCase {
    /**
     * Devuelve todas las tareas de una columna, validando acceso del usuario.
     *
     * @param columnId el UUID de la columna
     * @param userId   el UUID del usuario autenticado
     * @return lista de tareas ordenadas por posición
     */
    List<Task> getTasksByColumn(UUID columnId, UUID userId);
}
