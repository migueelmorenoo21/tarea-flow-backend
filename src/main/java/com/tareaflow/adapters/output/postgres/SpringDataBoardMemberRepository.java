package com.tareaflow.adapters.output.postgres;

import com.tareaflow.adapters.output.postgres.entity.BoardMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataBoardMemberRepository extends JpaRepository<BoardMemberEntity, UUID> {
    boolean existsByUserIdAndBoardId(UUID userId, UUID boardId);
}
