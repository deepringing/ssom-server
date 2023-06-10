package com.ullim.ssomserver.domain.todo.presentation.dto.response;

import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TodoResponseDto {

    private Long id;
    private String content;
    private Status status;

    public static TodoResponseDto of(Todo todo) {
        return TodoResponseDto.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .status(todo.getStatus())
                .build();
    }

}
