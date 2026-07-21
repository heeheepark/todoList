package org.example.todolist.comment.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todolist.comment.dto.*;
import org.example.todolist.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("users/{userId}/todos/{todoId}/comments")
    public ResponseEntity<CommentCreateResponse> create(
            @PathVariable Long userId,
            @PathVariable Long todoId,
            @Valid @RequestBody CommentCreateRequest request
    ) {
        return ResponseEntity.ok(commentService.create(userId, todoId, request));
    }

    @GetMapping("users/{userId}/todos/{todoId}/comments")
    public ResponseEntity<List<CommentGetResponse>> getAll(
            @PathVariable Long userId,
            @PathVariable Long todoId
    ) {
        return ResponseEntity.ok(commentService.getAll(userId, todoId));
    }

    @GetMapping("/users/{userId}/todos/{todoId}/comments/{commentId}")
    public ResponseEntity<CommentGetResponse> getOne(
            @PathVariable Long userId,
            @PathVariable Long todoId,
            @PathVariable Long commentId
    ) {
        return ResponseEntity.ok(commentService.getOne(userId, todoId, commentId));
    }

    @PutMapping("/users/{userId}/todos/{todoId}/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponse> update(
            @PathVariable Long userId,
            @PathVariable Long todoId,
            @PathVariable Long commentId,
            @RequestBody CommentUpdateRequest request
    ) {
        return ResponseEntity.ok(commentService.update(userId, todoId, commentId, request));
    }
}
