package com.ullim.ssomserver.domain.goal.service;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalListResponseDto;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetGoalListByTeamIdService {

    private final GoalRepository goalRepository;

    @Transactional
    public GoalListResponseDto execute(Long team_id){
        return new GoalListResponseDto(
                goalRepository.findGoalByTeamId(team_id).stream()
                        .map(this::createGoalResponse)
                        .collect(Collectors.toList())
        );
    }
    private GoalResponseDto createGoalResponse(Goal goal){
        return GoalResponseDto.of(goal);
    }

}
