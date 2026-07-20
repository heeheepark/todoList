package org.example.todolist.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.todo.dto.TodoCreateRequest;
import org.example.todolist.todo.dto.TodoCreateResponse;
import org.example.todolist.todo.dto.TodoGetResponse;
import org.example.todolist.todo.entity.Todo;
import org.example.todolist.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<TodoGetResponse> getAll() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoGetResponse> dtos = new ArrayList<>();

        for (Todo todo : todos) {
            dtos.add(new TodoGetResponse(
                    todo.getId(),
                    todo.getUsername(),
                    todo.getTitle(),
                    todo.getContent(),
                    todo.getCreatedAt(),
                    todo.getModifiedAt()
            ));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public TodoGetResponse getOne(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 할일 입니다.")
        );

        return new TodoGetResponse(
                todo.getId(),
                todo.getUsername(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt());
    }
}
