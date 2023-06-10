package com.ullim.ssomserver.domain.team.service;

import com.ullim.ssomserver.domain.team.domain.Member;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.team.domain.repository.MemberRepository;
import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.team.presentation.dto.request.CreateTeamRequestDto;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import com.ullim.ssomserver.global.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTeamService {

    private final TeamRepository teamRepository;
    private final UserFacade userFacade;
    private final MemberRepository memberRepository;

    @Transactional
    public void execute(CreateTeamRequestDto request) {
        User user = userFacade.getCurrentUser();
        Team team = teamRepository.save(Team.builder()
                .name(request.getName())
                .status(Status.STARTED)
                .build());
        Member member = Member.builder()
                .status(Status.STARTED)
                .user(user)
                .team(team)
                .build();
        memberRepository.save(member);
    }

}
