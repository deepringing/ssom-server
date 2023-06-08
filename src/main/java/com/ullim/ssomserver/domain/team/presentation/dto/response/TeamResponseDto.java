package com.ullim.ssomserver.domain.team.presentation.dto.response;

import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeamResponseDto {

    private Long id;
    private String name;
    private Status status;

    public static TeamResponseDto of(Team team) {
        return TeamResponseDto.builder()
                .id(team.getId())
                .name(team.getName())
                .status(team.getStatus())
                .build();
    }

}
