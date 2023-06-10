package com.ullim.ssomserver.domain.team.presentation.dto.response;

import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class TeamDetailResponseDto {

    private Long id;
    private String name;
    private Status status;
    private List<MemberResponse> memberList;

    public static TeamDetailResponseDto of(Team team) {
        return TeamDetailResponseDto.builder()
                .id(team.getId())
                .name(team.getName())
                .status(team.getStatus())
                .memberList(team.getMemberList()
                        .stream()
                        .map(MemberResponse::of)
                        .collect(Collectors.toList())
                )
                .build();
    }

}
