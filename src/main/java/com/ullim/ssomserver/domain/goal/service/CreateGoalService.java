package com.ullim.ssomserver.domain.goal.service;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.goal.presentation.dto.request.CreateGoalRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateGoalService {

    private final GoalRepository goalRepository;

    @Transactional
    public void execute(CreateGoalRequestDto request) {
        Goal goal = Goal.builder()
                .team(request.getTeam())
                .user(request.getUser())
                .completedAt(request.getCompletedAt())
                .build();
        goalRepository.save(goal);
    }



}
