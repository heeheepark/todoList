package org.example.todolist.todo.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TodoCreateRequest {
    @Size(min = 1, max = 100, message = "제목은 1자 이상 100자 이하여야 합니다.")
    private String title;

    @Size(max = 1000, message = "내용은 1000자 이내여야 합니다.")
    private String content;
}
