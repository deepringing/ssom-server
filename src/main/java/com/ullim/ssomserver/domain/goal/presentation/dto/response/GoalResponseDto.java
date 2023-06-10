package com.ullim.ssomserver.domain.goal.presentation.dto.response;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GoalResponseDto {

    private Long id;
    private String content;
    private LocalDate completedAt;
    private Status status;

    public static GoalResponseDto of(Goal goal) {
        return GoalResponseDto.builder()
                .id(goal.getId())
                .content(goal.getContent())
                .completedAt(goal.getCompletedAt())
                .status(goal.getStatus())
                .build();
    }

}
