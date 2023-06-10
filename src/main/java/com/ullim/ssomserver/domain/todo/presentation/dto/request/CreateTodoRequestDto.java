package com.ullim.ssomserver.domain.todo.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRequestDto {

    @NotNull
    private Long goalId;

    @NotNull
    private String content;

}
