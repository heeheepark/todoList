package org.example.todolist.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.user.dto.UserCreateRequest;
import org.example.todolist.user.dto.UserCreateRespone;
import org.example.todolist.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserCreateRespone> create(
            @RequestBody UserCreateRequest request
    ) {
        return ResponseEntity.ok(userService.save(request));
    }
}
