package com.ullim.ssomserver.domain.team.service;

import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.team.presentation.dto.request.CreateTeamRequestDto;
import com.ullim.ssomserver.global.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void execute(CreateTeamRequestDto request) {
        Team team = Team.builder()
                .name(request.getName())
                .status(Status.STARTED)
                .build();
        teamRepository.save(team);
    }

}
