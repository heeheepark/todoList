package org.example.todolist.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

}
