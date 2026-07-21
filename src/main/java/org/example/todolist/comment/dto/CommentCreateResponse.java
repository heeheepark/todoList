package org.example.todolist.comment.dto;

import lombok.Getter;
import org.example.todolist.todo.entity.Todo;
import org.example.todolist.user.entity.User;

@Getter
public class CommentCreateResponse {
    private final Long id;
    private final String content;
    private final User user;
    private final Todo todo;

    public CommentCreateResponse(Long id, String content, User user, Todo todo) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.todo = todo;
    }
}
