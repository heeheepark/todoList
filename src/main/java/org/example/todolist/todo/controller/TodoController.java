package org.example.todolist.todo.controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.todo.dto.TodoCreateRequest;
import org.example.todolist.todo.dto.TodoCreateResponse;
import org.example.todolist.todo.dto.TodoGetResponse;
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
}
