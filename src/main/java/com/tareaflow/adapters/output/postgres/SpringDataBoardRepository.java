package com.tareaflow.adapters.output.postgres;

import com.tareaflow.adapters.output.postgres.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataBoardRepository extends JpaRepository<BoardEntity, UUID> {
    boolean existsByIdAndOwnerId(UUID boardId, UUID ownerId);
}
