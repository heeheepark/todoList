package org.example.todolist.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.todo.dto.TodoCreateRequest;
import org.example.todolist.todo.dto.TodoCreateResponse;
import org.example.todolist.todo.entity.Todo;
import org.example.todolist.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoCreateResponse save(TodoCreateRequest request) {
        Todo todo = new Todo(request.getUsername(), request.getTitle(), request.getContent());
        Todo saveTodo = todoRepository.save(todo);

        return new TodoCreateResponse(
                saveTodo.getId(),
                saveTodo.getUsername(),
                saveTodo.getTitle(),
                saveTodo.getContent(),
                saveTodo.getCreatedAt(),
                saveTodo.getModifiedAt());
    }
}
