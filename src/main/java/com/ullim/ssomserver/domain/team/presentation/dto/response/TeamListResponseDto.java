package com.ullim.ssomserver.domain.team.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeamListResponseDto {

    private List<TeamResponseDto> TeamList;

}
