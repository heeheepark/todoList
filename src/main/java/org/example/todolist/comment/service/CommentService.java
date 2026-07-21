package org.example.todolist.comment.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todolist.comment.dto.CommentCreateRequest;
import org.example.todolist.comment.dto.CommentCreateResponse;
import org.example.todolist.comment.entity.Comment;
import org.example.todolist.comment.repository.CommentRepository;
import org.example.todolist.todo.entity.Todo;
import org.example.todolist.todo.exception.TodoNotFoundException;
import org.example.todolist.todo.repository.TodoRepository;
import org.example.todolist.user.entity.User;
import org.example.todolist.user.exception.UserNotFoundException;
import org.example.todolist.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Transactional
    public CommentCreateResponse create(Long userId, Long todoId, @Valid CommentCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("존재하지 않는 사용자 입니다.")
        );

        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new TodoNotFoundException("존재하지 않는 일정 입니다.")
        );

        Comment comment = new Comment(request.getContent(), user, todo);
        Comment saveComment = commentRepository.save(comment);

        return new CommentCreateResponse(saveComment.getId(), saveComment.getContent(), saveComment.getUser(), saveComment.getTodo());
    }
}
