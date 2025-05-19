package com.tareaflow.adapters.input.rest;

import com.tareaflow.adapters.input.rest.dto.CreateColumnRequest;
import com.tareaflow.domain.model.Column;
import com.tareaflow.domain.port.in.CreateColumnUseCase;
import com.tareaflow.domain.port.in.GetColumnsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/boards/{boardId}/columns")
public class ColumnController {

    private final CreateColumnUseCase createColumnUseCase;
    private final GetColumnsUseCase getColumnsUseCase;

    public ColumnController(CreateColumnUseCase createColumnUseCase,
                            GetColumnsUseCase getColumnsUseCase) {
        this.createColumnUseCase = createColumnUseCase;
        this.getColumnsUseCase = getColumnsUseCase;
    }

    @PostMapping
    public ResponseEntity<Column> createColumn(
            @PathVariable UUID boardId,
            @RequestBody CreateColumnRequest request,
            HttpServletRequest httpRequest
    ) {
        UUID userId = UUID.fromString((String) httpRequest.getAttribute("userId"));
        Column created = createColumnUseCase.createColumn(boardId, request, userId);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Column>> listColumns(
            @PathVariable UUID boardId,
            HttpServletRequest httpRequest
    ) {
        UUID userId = UUID.fromString((String) httpRequest.getAttribute("userId"));
        List<Column> columns = getColumnsUseCase.getColumnsByBoard(boardId, userId);
        return ResponseEntity.ok(columns);
    }
}
