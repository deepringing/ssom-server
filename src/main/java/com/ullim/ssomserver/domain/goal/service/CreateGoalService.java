package com.ullim.ssomserver.domain.goal.service;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.goal.domain.type.GoalType;
import com.ullim.ssomserver.domain.goal.presentation.dto.request.CreateGoalRequestDto;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateGoalService {

    private final GoalRepository goalRepository;
    private final UserFacade userFacade;
    private final TeamRepository teamRepository;

    @Transactional
    public void execute(CreateGoalRequestDto request) {
        User user = userFacade.getCurrentUser();
        Team team = null;
        if (Objects.nonNull(request.getTeamId())) {
            team = teamRepository.findTeamById(request.getTeamId());
        }

        Goal goal = Goal.builder()
                .content(request.getContent())
                .completedAt(request.getCompletedAt())
                .team(team)
                .user(user)
                .type(Objects.nonNull(team) ? GoalType.TEAM : GoalType.PERSONAL)
                .build();

        goalRepository.save(goal);
    }
}
