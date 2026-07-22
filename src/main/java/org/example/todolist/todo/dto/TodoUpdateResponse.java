package org.example.todolist.todo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final Long userId;
    private final String username;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoUpdateResponse(Long id, String title, String content, Long userId, String username, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.username = username;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
