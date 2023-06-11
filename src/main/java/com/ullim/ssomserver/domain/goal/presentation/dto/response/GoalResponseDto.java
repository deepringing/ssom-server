package com.ullim.ssomserver.domain.goal.presentation.dto.response;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GoalResponseDto {

    private static TodoRepository todoRepository;

    private Long id;
    private String content;
    private LocalDate completedAt;
    private Status status;
    private Long percentage;

    public static GoalResponseDto of(Goal goal) {

        return GoalResponseDto.builder()
                .id(goal.getId())
                .content(goal.getContent())
                .completedAt(goal.getCompletedAt())
                .status(goal.getStatus())
                .percentage(todoRepository.findTodoByGoalId(goal.getId()).size()/todoRepository.findTodoByGoalId(goal.getId()).stream().filter(g -> g.getStatus() == Status.COMPLETED).count())
                .build();
    }

}
