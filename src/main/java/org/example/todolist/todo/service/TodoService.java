package org.example.todolist.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.todo.dto.*;
import org.example.todolist.todo.entity.Todo;
import org.example.todolist.todo.exception.TodoNotFoundException;
import org.example.todolist.todo.repository.TodoRepository;
import org.example.todolist.user.entity.User;
import org.example.todolist.user.exception.UserNotFoundException;
import org.example.todolist.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public TodoCreateResponse save(Long userId, TodoCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("존재하지 않는 유저입니다")
        );

        Todo todo = new Todo(user, request.getTitle(), request.getContent());
        Todo saveTodo = todoRepository.save(todo);

        return new TodoCreateResponse(
                saveTodo.getId(),
                saveTodo.getUser(),
                saveTodo.getTitle(),
                saveTodo.getContent(),
                saveTodo.getCreatedAt(),
                saveTodo.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public List<TodoGetResponse> getAll(Long userId) {
        List<Todo> todos = todoRepository.findByUserId(userId);
        List<TodoGetResponse> dtos = new ArrayList<>();

        for (Todo todo : todos) {
            dtos.add(new TodoGetResponse(
                    todo.getId(),
                    todo.getUser(),
                    todo.getTitle(),
                    todo.getContent(),
                    todo.getCreatedAt(),
                    todo.getModifiedAt()
            ));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public TodoGetResponse getOne(Long userId, Long todoId) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId).orElseThrow(
                () -> new TodoNotFoundException("존재하지 않는 일정 입니다.")
        );

        return new TodoGetResponse(
                todo.getId(),
                todo.getUser(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt());
    }

    @Transactional
    public TodoUpdateResponse update(Long userId, Long todoId, TodoUpdateRequest request) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId).orElseThrow(
                () -> new TodoNotFoundException("존재하지 않는 일정 입니다.")
        );

        todo.updateTodo(request.getTitle(), request.getContent());
        return new TodoUpdateResponse(
                todo.getId(),
                todo.getUser(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt());
    }

    @Transactional
    public void delete(Long userId, Long todoId) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId).orElseThrow(
                () -> new TodoNotFoundException("존재하지 않는 일정 입니다.")
        );

        todoRepository.delete(todo);
    }
}
