package org.example.todolist.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.user.dto.UserCreateRequest;
import org.example.todolist.user.dto.UserCreateRespone;
import org.example.todolist.user.dto.UserGetResponse;
import org.example.todolist.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/users")
    public ResponseEntity<List<UserGetResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserGetResponse> getOne(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userService.getOne(userId));
    }
}
