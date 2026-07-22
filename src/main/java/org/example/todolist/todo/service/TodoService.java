package org.example.todolist.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.comment.repository.CommentRepository;
import org.example.todolist.todo.dto.*;
import org.example.todolist.todo.entity.Todo;
import org.example.todolist.todo.exception.TodoNotFoundException;
import org.example.todolist.todo.repository.TodoRepository;
import org.example.todolist.user.entity.User;
import org.example.todolist.user.exception.UserNotFoundException;
import org.example.todolist.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public TodoCreateResponse save(Long userId, TodoCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("존재하지 않는 유저입니다")
        );

        Todo todo = new Todo(user, request.getTitle(), request.getContent());
        Todo saveTodo = todoRepository.save(todo);

        return new TodoCreateResponse(
                saveTodo.getId(),
                saveTodo.getTitle(),
                saveTodo.getContent(),
                saveTodo.getUser().getId(),
                saveTodo.getUser().getName(),
                saveTodo.getCreatedAt(),
                saveTodo.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public Page<TodoPagingResponse> getAll(Long userId, Pageable pageable) {
        return todoRepository.findByUserIdOrderByModifiedAtDesc(userId, pageable)
                .map(todo -> new TodoPagingResponse(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getContent(),
                        commentRepository.countByTodoId(todo.getId()),
                        todo.getUser().getName(),
                        todo.getCreatedAt(),
                        todo.getModifiedAt()
                ));
    }

    @Transactional(readOnly = true)
    public TodoGetResponse getOne(Long userId, Long todoId) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId).orElseThrow(
                () -> new TodoNotFoundException("존재하지 않는 일정 입니다.")
        );

        return new TodoGetResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getContent(),
                todo.getUser().getId(),
                todo.getUser().getName(),
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
                todo.getTitle(),
                todo.getContent(),
                todo.getUser().getId(),
                todo.getUser().getName(),
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
