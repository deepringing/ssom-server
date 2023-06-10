package com.ullim.ssomserver.domain.todo.presentation.dto.response;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TodoResponseDto {

    private Long id;
    private User user;
    private String content;
    private Goal goal;
    private Status status;

    public static TodoResponseDto of(Todo todo) {
        return TodoResponseDto.builder()
                .id(todo.getId())
                .user(todo.getUser())
                .content(todo.getContent())
                .status(todo.getStatus())
                .build();
    }

}
