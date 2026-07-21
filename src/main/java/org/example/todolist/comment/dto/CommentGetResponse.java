package org.example.todolist.comment.dto;

import lombok.Getter;
import org.example.todolist.todo.entity.Todo;
import org.example.todolist.user.entity.User;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponse {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final User user;
    private final Todo todo;

    public CommentGetResponse(Long id, String content, LocalDateTime createdAt, LocalDateTime modifiedAt, User user, Todo todo) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.user = user;
        this.todo = todo;
    }
}
