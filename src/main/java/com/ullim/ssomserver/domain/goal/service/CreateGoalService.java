package com.ullim.ssomserver.domain.goal.service;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.goal.presentation.dto.request.CreateGoalRequestDto;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.user.domain.Repository.UserRepository;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateGoalService {

    private final GoalRepository goalRepository;
    private final UserFacade userFacade;
    private final TeamRepository teamRepository;

    @Transactional
    public void execute(CreateGoalRequestDto request) {
        User user = userFacade.getCurrentUser();
        Team team = teamRepository.findTeamById(request.getTeamId());
        Goal goal = Goal.builder()
                .content(request.getContent())
                .team(team)
                .user(user)
                .build();
        goalRepository.save(goal);
    }



}
