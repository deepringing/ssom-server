package com.ullim.ssomserver.domain.goal.presentation.dto.response;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class GoalResponseDto {

    private Long id;
    private String content;
    private LocalDate completedAt;
    private Status status;
    private Integer percentage;

    public static GoalResponseDto of(Goal goal, TodoRepository todoRepository) {
        List<Todo> todoList = todoRepository.findTodoByGoalId(goal.getId());

        return GoalResponseDto.builder()
                .id(goal.getId())
                .content(goal.getContent())
                .completedAt(goal.getCompletedAt())
                .status(goal.getStatus())
                .percentage(
                        todoList.size() == 0 ?
                                0 :
                                Math.toIntExact(Math.round(
                                        (double) todoList.stream().filter(g -> g.getStatus() == Status.COMPLETED).count()
                                                / (double) todoList.size() * 100.0
                                ))
                )
                .build();
    }

}
