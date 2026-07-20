package org.example.todolist.todo.dto;

import lombok.Getter;
import org.example.todolist.user.entity.User;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateResponse {
    private final Long id;
    private final User user;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoUpdateResponse(Long id, User user, String title, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
