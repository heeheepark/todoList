package org.example.todolist.todo.controller;

import jakarta.validation.Valid;
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

    @PostMapping("users/{userId}/todos")
    public ResponseEntity<TodoCreateResponse> create(
            @PathVariable Long userId,
            @Valid @RequestBody TodoCreateRequest request
    ) {
        return ResponseEntity.ok(todoService.save(userId, request));
    }

    @GetMapping("users/{userId}/todos")
    public ResponseEntity<List<TodoGetResponse>> getAll(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(todoService.getAll(userId));
    }

    @GetMapping("users/{userId}/todos/{todoId}")
    public ResponseEntity<TodoGetResponse> getOne(
            @PathVariable Long userId,
            @PathVariable Long todoId
    ) {
        return ResponseEntity.ok(todoService.getOne(userId, todoId));
    }

    @PutMapping("users/{userId}/todos/{todoId}")
    public ResponseEntity<TodoUpdateResponse> update(
            @PathVariable Long userId,
            @PathVariable Long todoId,
            @Valid @RequestBody TodoUpdateRequest request
    ) {
        return ResponseEntity.ok(todoService.update(userId, todoId, request));
    }

    @DeleteMapping("users/{userId}/todos/{todoId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId,
            @PathVariable Long todoId
    ) {
        todoService.delete(userId, todoId);
        return ResponseEntity.ok().build();
    }
}
