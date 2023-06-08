package com.ullim.ssomserver.domain.team.presentation;

import com.ullim.ssomserver.domain.team.presentation.dto.request.CreateTeamRequestDto;
import com.ullim.ssomserver.domain.team.presentation.dto.response.TeamListResponseDto;
import com.ullim.ssomserver.domain.team.service.CreateTeamService;
import com.ullim.ssomserver.domain.team.service.GetTeamListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final CreateTeamService createTeamService;
    private final GetTeamListService getTeamListService;

    @PostMapping
    public void saveTeam(@RequestBody @Valid CreateTeamRequestDto request) {
        createTeamService.execute(request);
    }

    @GetMapping
    public TeamListResponseDto getUserTeam() {return getTeamListService.execute();}

}
