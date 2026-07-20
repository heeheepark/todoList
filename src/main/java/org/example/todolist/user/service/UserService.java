package org.example.todolist.user.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
}
