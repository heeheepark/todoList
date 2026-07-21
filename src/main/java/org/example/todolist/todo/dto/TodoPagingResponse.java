package org.example.todolist.todo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoPagingResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final Long commentCount;
    private final String username;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoPagingResponse(Long id, String title, String content, Long commentCount, String username, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.commentCount = commentCount;
        this.username = username;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
