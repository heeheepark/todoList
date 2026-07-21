package org.example.todolist.comment.dto;

import lombok.Getter;
import org.example.todolist.todo.entity.Todo;
import org.example.todolist.user.entity.User;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponse {
    private final Long id;
    private final String content;
    private final User user;
    private final Todo todo;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentGetResponse(Long id, String content, User user, Todo todo, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.todo = todo;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
