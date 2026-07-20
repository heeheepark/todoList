package org.example.todolist.todo.controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.todo.dto.*;
import org.example.todolist.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoCreateResponse> create(
            @RequestBody TodoCreateRequest request
    ) {
        return ResponseEntity.ok(todoService.save(request));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoGetResponse>> getAll() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<TodoGetResponse> getOne(
            @PathVariable Long todoId
    ) {
        return ResponseEntity.ok(todoService.getOne(todoId));
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<TodoUpdateResponse> update(
            @PathVariable Long todoId,
            @RequestBody TodoUpdateRequest request
    ) {
        return ResponseEntity.ok(todoService.update(todoId, request));
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<List<TodoGetResponse>> delete(
            @PathVariable Long todoId
    ) {
        todoService.delete(todoId);
        return ResponseEntity.ok(todoService.getAll());
    }
}
