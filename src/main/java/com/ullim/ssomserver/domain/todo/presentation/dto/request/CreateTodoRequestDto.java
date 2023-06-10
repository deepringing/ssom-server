package com.ullim.ssomserver.domain.todo.presentation.dto.request;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRequestDto {

    @NotNull
    private Goal goal;

    private String content;

}
