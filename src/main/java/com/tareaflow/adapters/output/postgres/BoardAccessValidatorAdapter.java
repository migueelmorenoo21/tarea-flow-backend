package com.tareaflow.adapters.output.postgres;

import com.tareaflow.domain.port.out.BoardAccessValidator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BoardAccessValidatorAdapter implements BoardAccessValidator {

    private final SpringDataBoardMemberRepository boardMemberRepository;
    private final SpringDataBoardRepository boardRepository;

    public BoardAccessValidatorAdapter(
            SpringDataBoardMemberRepository boardMemberRepository,
            SpringDataBoardRepository boardRepository
    ) {
        this.boardMemberRepository = boardMemberRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public boolean isMember(UUID userId, UUID boardId) {
        return boardMemberRepository.existsByUserIdAndBoardId(userId, boardId);
    }

    @Override
    public boolean isOwner(UUID userId, UUID boardId) {
        return boardRepository.existsByIdAndOwnerId(boardId, userId);
    }
}
