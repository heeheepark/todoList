package org.example.todolist.todo.repository;

import org.example.todolist.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findByUserIdOrderByModifiedAtDesc(Long userId, Pageable pageable);

    Optional<Todo> findByIdAndUserId(Long todoId, Long userId);
}