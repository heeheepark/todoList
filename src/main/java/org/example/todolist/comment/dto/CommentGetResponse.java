package org.example.todolist.comment.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponse {
    private final Long id;
    private final String content;
    private final Long userId;
    private final String username;
    private final Long todoId;
    private final String todoTitle;
    private final String todoContent;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentGetResponse(Long id, String content, Long userId, String username, Long todoId, String todoTitle, String todoContent, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.username = username;
        this.todoId = todoId;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
