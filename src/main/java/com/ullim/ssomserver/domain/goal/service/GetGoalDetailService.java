package com.ullim.ssomserver.domain.goal.service;

import com.ullim.ssomserver.domain.goal.facade.GoalFacade;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalDetailResponseDto;
import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GetGoalDetailService {

    private final GoalFacade goalFacade;
    private final TodoRepository todoRepository;

    @Transactional
    public GoalDetailResponseDto execute(Long id) {

        return GoalDetailResponseDto.of(
                goalFacade.findGoalById(id),
                todoRepository
        );
    }
}
