package org.example.todolist.comment.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentUpdateRequest {
    @Size(min = 1, message = "내용을 입력해주세요.")
    private String content;
}
