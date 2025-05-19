package com.tareaflow.adapters.input.rest;

import com.tareaflow.adapters.input.rest.dto.BoardResponse;
import com.tareaflow.adapters.input.rest.dto.CreateBoardRequest;
import com.tareaflow.domain.model.Board;
import com.tareaflow.domain.port.in.CreateBoardUseCase;
import com.tareaflow.domain.port.in.GetBoardsUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final GetBoardsUseCase getBoardsUseCase;
    private final CreateBoardUseCase createBoardUseCase;

    public BoardController(
            GetBoardsUseCase getBoardsUseCase,
            CreateBoardUseCase createBoardUseCase
    ) {
        this.getBoardsUseCase = getBoardsUseCase;
        this.createBoardUseCase = createBoardUseCase;
    }

    @GetMapping
    public ResponseEntity<List<BoardResponse>> getBoards(HttpServletRequest request) {
        String userIdStr = (String) request.getAttribute("userId");
        if (userIdStr == null) {
            return ResponseEntity.status(401).build();
        }

        UUID userId = UUID.fromString(userIdStr);
        List<Board> boards = getBoardsUseCase.getBoardsForUser(userId);

        List<BoardResponse> response = boards.stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<BoardResponse> createBoard(
            HttpServletRequest request,
            @RequestBody CreateBoardRequest body
    ) {
        String userIdStr = (String) request.getAttribute("userId");
        if (userIdStr == null) {
            return ResponseEntity.status(401).build();
        }

        UUID ownerId = UUID.fromString(userIdStr);
        Board newBoard = createBoardUseCase.createBoard(ownerId, body.title, body.description);
        return ResponseEntity.ok(new BoardResponse(newBoard));
    }
}
