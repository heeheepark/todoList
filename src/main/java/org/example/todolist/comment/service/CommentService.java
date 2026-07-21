package org.example.todolist.comment.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todolist.comment.dto.*;
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

import java.util.List;

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

        return new CommentCreateResponse(
                saveComment.getId(),
                saveComment.getContent(),
                saveComment.getUser(),
                saveComment.getTodo(),
                saveComment.getCreatedAt(),
                saveComment.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<CommentGetResponse> getAll(Long userId, Long todoId) {
        List<Comment> comments = commentRepository.findByUserIdAndTodoId(userId, todoId);
        return comments.stream()
                .map(comment -> new CommentGetResponse(
                        comment.getId(),
                        comment.getContent(),
                        comment.getUser(),
                        comment.getTodo(),
                        comment.getCreatedAt(),
                        comment.getModifiedAt()
                )).toList();
    }

    @Transactional(readOnly = true)
    public CommentGetResponse getOne(Long userId, Long todoId, Long commentId) {
        Comment comment = commentRepository.findByIdAndUserIdAndTodoId(commentId, userId, todoId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글 입니다.")
        );

        return new CommentGetResponse(
                comment.getId(),
                comment.getContent(),
                comment.getUser(),
                comment.getTodo(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }

    @Transactional
    public CommentUpdateResponse update(Long userId, Long todoId, Long commentId, CommentUpdateRequest request) {
        Comment comment = commentRepository.findByIdAndUserIdAndTodoId(commentId, userId, todoId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글 입니다.")
        );

        comment.updateComment(request.getContent());

        return new CommentUpdateResponse(
                comment.getId(),
                comment.getContent(),
                comment.getUser(),
                comment.getTodo(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long userId, Long todoId, Long commentId) {
        Comment comment = commentRepository.findByIdAndUserIdAndTodoId(commentId, userId, todoId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글 입니다.")
        );

        commentRepository.delete(comment);
    }
}
