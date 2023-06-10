package com.ullim.ssomserver.domain.team.service;

import com.ullim.ssomserver.domain.team.domain.Member;
import com.ullim.ssomserver.domain.team.domain.repository.MemberRepository;
import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.team.presentation.dto.request.CreateMemberRequestDto;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import com.ullim.ssomserver.global.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMemberService {

    private final UserFacade userFacade;
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void execute(CreateMemberRequestDto request) {
        Member member = Member.builder()
                .status(Status.STARTED)
                .user(userFacade.findUserByEmail(request.getEmail()))
                .team(teamRepository.findTeamById(request.getTeamId()))
                .build();

        memberRepository.save(member);
    }

}
