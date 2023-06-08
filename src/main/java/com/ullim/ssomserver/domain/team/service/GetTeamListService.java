package com.ullim.ssomserver.domain.team.service;

import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamListResponseDto;
import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GetTeamListService {

    private final TeamRepository teamRepository;

    @Transactional
    public TeamListResponseDto execute(){
        return new TeamListResponseDto(
                teamRepository.findAll()
                        .stream().map(TeamResponseDto::of)
                        .toList()
        );
    }

}
