package org.example.todolist.todo.dto;

import lombok.Getter;

@Getter
public class TodoCreateRequest {
    private String username;
    private String title;
    private String content;
}
