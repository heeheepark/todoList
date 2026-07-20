package org.example.todolist.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserUpdateRequest {
    private String name;

    @Email(message = "이메일 형식으로 입력하세요.")
    private String email;

    @Size(min = 8, message = "비밀번호는 8자리 이상이어야 합니다.")
    private String password;
}
