package org.example.todolist.comment.controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.comment.service.CommentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
}
