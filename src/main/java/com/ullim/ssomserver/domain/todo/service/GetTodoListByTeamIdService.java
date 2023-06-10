package com.ullim.ssomserver.domain.todo.service;

import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import com.ullim.ssomserver.domain.todo.presentation.dto.response.TodoListResponseDto;
import com.ullim.ssomserver.domain.todo.presentation.dto.response.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetTodoListByTeamIdService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoListResponseDto execute(Long goalId) {
        return new TodoListResponseDto(
                todoRepository.findTodoByGoalId(goalId)
                        .stream()
                        .map(TodoResponseDto::of)
                        .collect(Collectors.toList())
        );
    }
}
