package com.ullim.ssomserver.domain.team.presentation.dto.response;

import com.ullim.ssomserver.domain.team.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponse {

    private Long id;
    private String name;

    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getUser().getNickname())
                .build();
    }
}