package org.example.todolist.todo.controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.todo.dto.TodoCreateRequest;
import org.example.todolist.todo.dto.TodoCreateResponse;
import org.example.todolist.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
