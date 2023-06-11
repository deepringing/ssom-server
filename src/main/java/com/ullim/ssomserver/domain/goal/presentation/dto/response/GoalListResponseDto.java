package com.ullim.ssomserver.domain.goal.presentation.dto.response;

import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamDetailResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GoalListResponseDto {
<<<<<<< HEAD

    private TeamDetailResponseDto team;
=======
>>>>>>> c4c2e60 (ADD: Percentage in goal response dto and only fetch my goal not team)
    private List<GoalResponseDto> GoalList;
}
