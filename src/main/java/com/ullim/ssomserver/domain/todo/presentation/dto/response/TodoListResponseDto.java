package com.ullim.ssomserver.domain.todo.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TodoListResponseDto {

    private List<TodoResponseDto> GoalList;

}
