package org.example.todolist.comment.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todolist.comment.dto.CommentCreateRequest;
import org.example.todolist.comment.dto.CommentCreateResponse;
import org.example.todolist.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
