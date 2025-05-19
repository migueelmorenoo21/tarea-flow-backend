package com.tareaflow.domain.usecase;

import com.tareaflow.domain.model.Board;
import com.tareaflow.domain.port.in.GetBoardsUseCase;
import com.tareaflow.domain.port.out.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetBoardsService implements GetBoardsUseCase {

    private final BoardRepository boardRepository;

    public GetBoardsService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> getBoardsForUser(UUID userId) {
        return boardRepository.findAllByUserId(userId);
    }
}