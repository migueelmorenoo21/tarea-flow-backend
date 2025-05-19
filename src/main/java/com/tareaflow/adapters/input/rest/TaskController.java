package com.tareaflow.adapters.input.rest;

import com.tareaflow.adapters.input.rest.dto.CreateTaskRequest;
import com.tareaflow.domain.model.Task;
import com.tareaflow.domain.port.in.CreateTaskUseCase;
import com.tareaflow.domain.port.in.GetTasksByColumnUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetTasksByColumnUseCase getTasksByColumnUseCase;

    public TaskController(
            CreateTaskUseCase createTaskUseCase,
            GetTasksByColumnUseCase getTasksByColumnUseCase
    ) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTasksByColumnUseCase = getTasksByColumnUseCase;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(
            @RequestBody CreateTaskRequest request,
            HttpServletRequest httpRequest
    ) {
        UUID userId = UUID.fromString((String) httpRequest.getAttribute("userId"));
        Task created = createTaskUseCase.createTask(request, userId);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/columns/{columnId}/tasks")
    public ResponseEntity<List<Task>> listTasksByColumn(
            @PathVariable UUID columnId,
            HttpServletRequest httpRequest
    ) {
        UUID userId = UUID.fromString((String) httpRequest.getAttribute("userId"));
        List<Task> tasks = getTasksByColumnUseCase.getTasksByColumn(columnId, userId);
        return ResponseEntity.ok(tasks);
    }
}
