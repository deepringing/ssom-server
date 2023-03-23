package com.ullim.ssomserver.domain.goal.presentation;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.goal.facade.GoalFacade;
import com.ullim.ssomserver.domain.goal.presentation.dto.request.CreateGoalRequestDto;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;
    private final GoalFacade goalFacade;
    private final UserFacade userFacade;

    @Transactional
    public void createGoal(CreateGoalRequestDto request) {
        Goal goal = Goal.builder()
                .team(request.getTeam())
                .user(request.getUser())
                .completedAt(request.getCompletedAt())
                .build();
        goalRepository.save(goal);
    }

}
