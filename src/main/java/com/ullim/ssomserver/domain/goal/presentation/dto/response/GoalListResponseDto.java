package com.ullim.ssomserver.domain.goal.presentation.dto.response;

import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamDetailResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GoalListResponseDto {

    private TeamDetailResponseDto team;
    private List<GoalResponseDto> GoalList;
}
