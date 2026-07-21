package org.example.todolist.comment.repository;

import org.example.todolist.comment.entity.Comment;
import org.example.todolist.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> todo(Todo todo);

    List<Comment> findByUserIdAndTodoId(Long userId, Long todoId);

    Optional<Comment> findByIdAndUserIdAndTodoId(Long commentId, Long userId, Long todoId);
}
