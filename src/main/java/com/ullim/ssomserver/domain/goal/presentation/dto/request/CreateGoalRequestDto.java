package com.ullim.ssomserver.domain.goal.presentation.dto.request;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateGoalRequestDto {

    @NotNull
    private Long id;

    @NotNull
    private User user;

    @NotNull
    private Team team;

    @NotNull
    private LocalDateTime completedAt;

    @NotNull
    private String status;

}
