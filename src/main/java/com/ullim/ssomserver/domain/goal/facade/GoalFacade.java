package com.ullim.ssomserver.domain.goal.facade;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.goal.exception.GoalNotFoundException;
import com.ullim.ssomserver.global.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoalFacade {

    private final GoalRepository goalRepository;

    public Goal findGoalById(Long id) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> GoalNotFoundException.EXCEPTION);
        if (goal.getStatus() == Status.DELETED)
            throw GoalNotFoundException.EXCEPTION;
        return goal;
    }

}
