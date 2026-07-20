package org.example.todolist.todo.exception;

import org.springframework.http.HttpStatus;

public class TodoNotFoundException extends ServiceException {
    public TodoNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message); // HttpStatus.NOT_FOUND 지정
    }
}
