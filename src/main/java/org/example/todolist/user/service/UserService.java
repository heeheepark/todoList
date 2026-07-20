package org.example.todolist.user.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.config.PasswordEncoder;
import org.example.todolist.user.dto.*;
import org.example.todolist.user.entity.User;
import org.example.todolist.user.exception.UserNotFoundException;
import org.example.todolist.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserCreateRespone save(UserCreateRequest request) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(request.getName(), request.getEmail(), encodedPassword);
        User saveUser = userRepository.save(user);

        return new UserCreateRespone(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getEmail(),
                saveUser.getCreatedAt(),
                saveUser.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public List<UserGetResponse> getAll() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> (
                new UserGetResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCreatedAt(),
                        user.getModifiedAt()
                ))).toList();

    }

    @Transactional(readOnly = true)
    public UserGetResponse getOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("존재하지 않는 사용자 입니다.")
        );

        return new UserGetResponse(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt());
    }

    @Transactional
    public UserUpdateResponse update(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("존재하지 않는 사용자 입니다.")
        );

        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        user.updateUser(request.getName(), request.getEmail(), encodedPassword);
        return new UserUpdateResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getCreatedAt()
        );
    }

    @Transactional
    public void delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("존재하지 않는 사용자 입니다.")
        );

        userRepository.delete(user);
    }
}
