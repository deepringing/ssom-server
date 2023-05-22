package com.ullim.ssomserver.domain.goal.presentation.dto.response;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
public class GoalResponseDto {

    private Long id;
    private User user;
    private Team team;
    private LocalDateTime completedAt;
    private Status status;

    public static GoalResponseDto of(Goal goal) {
        return GoalResponseDto.builder()
                .id(goal.getId())
                .user(goal.getUser())
                .team(goal.getTeam())
                .completedAt(goal.getCompletedAt())
                .status(goal.getStatus())
                .build();
    }

}
