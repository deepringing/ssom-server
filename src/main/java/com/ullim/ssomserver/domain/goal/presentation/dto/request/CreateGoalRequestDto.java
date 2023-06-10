package com.ullim.ssomserver.domain.goal.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateGoalRequestDto {

    @NotNull
    private String content;

    private Long teamId;

    @NotNull
    private LocalDate completedAt;
}
