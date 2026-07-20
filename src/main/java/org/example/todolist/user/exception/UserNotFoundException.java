package org.example.todolist.user.exception;

import org.example.todolist.todo.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message); // HttpStatus.NOT_FOUND 지정
    }
}
