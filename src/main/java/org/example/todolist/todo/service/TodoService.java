package org.example.todolist.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
}
