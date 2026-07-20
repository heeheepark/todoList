package org.example.todolist.user.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.user.dto.UserCreateRequest;
import org.example.todolist.user.dto.UserCreateRespone;
import org.example.todolist.user.entity.User;
import org.example.todolist.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserCreateRespone save(UserCreateRequest request) {
        User user = new User(request.getName(), request.getEmail());
        User saveUser = userRepository.save(user);

        return new UserCreateRespone(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getEmail(),
                saveUser.getCreatedAt(),
                saveUser.getModifiedAt());
    }
}
