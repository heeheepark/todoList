package org.example.todolist.todo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todos")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String title;
    private String content;

    public Todo(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public void updateTodo(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
