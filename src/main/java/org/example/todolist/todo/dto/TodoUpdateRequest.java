package org.example.todolist.todo.dto;

import lombok.Getter;

@Getter
public class TodoUpdateRequest {
    private String username;
    private String title;
    private String content;
}
