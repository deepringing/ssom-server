package com.ullim.ssomserver.domain.goal.service;

import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalListResponseDto;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalResponseDto;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetGoalListByTeamIdService {

    private final TeamRepository teamRepository;
    private final GoalRepository goalRepository;

    @Transactional
    public GoalListResponseDto execute(Long teamId) {
        Team team = teamRepository.findTeamById(teamId);

        return new GoalListResponseDto(
                TeamDetailResponseDto.of(team),
                goalRepository.findGoalByTeam(team).stream()
                        .map(GoalResponseDto::of)
                        .collect(Collectors.toList())
        );
    }
}
