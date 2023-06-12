package com.ullim.ssomserver.domain.goal.presentation.dto.response;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import com.ullim.ssomserver.domain.todo.presentation.dto.response.TodoResponseDto;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class GoalDetailResponseDto {

    private Long id;
    private String content;
    private LocalDate completedAt;
    private LocalDateTime createdAt;
    private Status status;
    private Integer percentage;
    private List<TodoResponseDto> todoList;

    public static GoalDetailResponseDto of(Goal goal, TodoRepository todoRepository) {
        List<Todo> todoList = todoRepository.findTodoByGoalId(goal.getId());

        return GoalDetailResponseDto.builder()
                .id(goal.getId())
                .content(goal.getContent())
                .completedAt(goal.getCompletedAt())
                .createdAt(goal.getCreatedAt())
                .status(goal.getStatus())
                .percentage(
                        todoList.size() == 0 ?
                                0 :
                                Math.toIntExact(Math.round(
                                        (double) todoList.stream().filter(g -> g.getStatus() == Status.COMPLETED).count()
                                                / (double) todoList.size() * 100.0
                                ))
                )
                .todoList(
                        todoList.stream()
                                .map(TodoResponseDto::of)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
