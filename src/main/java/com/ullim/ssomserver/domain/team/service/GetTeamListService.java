package com.ullim.ssomserver.domain.team.service;

import com.ullim.ssomserver.domain.team.domain.Member;
import com.ullim.ssomserver.domain.team.domain.repository.MemberRepository;
import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamListResponseDto;
import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamResponseDto;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetTeamListService {

    private final MemberRepository memberRepository;
    private final UserFacade userFacade;

    @Transactional
    public TeamListResponseDto execute() {
        User user = userFacade.getCurrentUser();

        return new TeamListResponseDto(
                memberRepository.findByUser(user)
                        .stream()
                        .map(Member::getTeam)
                        .map(TeamResponseDto::of)
                        .collect(Collectors.toList())
        );
    }

}
