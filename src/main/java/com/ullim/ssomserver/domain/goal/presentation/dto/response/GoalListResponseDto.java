package com.ullim.ssomserver.domain.goal.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class GoalListResponseDto {

    private List<GoalResponseDto> GoalList;

}
