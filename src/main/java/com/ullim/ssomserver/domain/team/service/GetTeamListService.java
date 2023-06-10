package com.ullim.ssomserver.domain.team.service;

import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamListResponseDto;
import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamResponseDto;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GetTeamListService {

    private final TeamRepository teamRepository;
    private final UserFacade userFacade;

    @Transactional
    public TeamListResponseDto execute(){
        User user = userFacade.getCurrentUser();

        return new TeamListResponseDto(
                teamRepository.findTeamByUser(user)
                        .stream().map(TeamResponseDto::of)
                        .toList()
        );
    }

}
