package com.tareaflow.domain.usecase;

import com.tareaflow.domain.model.Board;
import com.tareaflow.domain.port.in.CreateBoardUseCase;
import com.tareaflow.domain.port.out.BoardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CreateBoardService implements CreateBoardUseCase {

    private final BoardRepository boardRepository;

    public CreateBoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board createBoard(UUID ownerId, String title, String description) {
        Board board = new Board(
                UUID.randomUUID(),
                title,
                description,
                ownerId,
                LocalDateTime.now()
        );
        return boardRepository.save(board);
    }
}
