package com.ullim.ssomserver.domain.goal.presentation;

import com.ullim.ssomserver.domain.goal.presentation.dto.request.CreateGoalRequestDto;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalDetailResponseDto;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalListResponseDto;
import com.ullim.ssomserver.domain.goal.service.CreateGoalService;
import com.ullim.ssomserver.domain.goal.service.GetGoalDetailService;
import com.ullim.ssomserver.domain.goal.service.GetGoalListByTeamIdService;
import com.ullim.ssomserver.domain.goal.service.GetGoalListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/goal")
@RequiredArgsConstructor
public class GoalController {

    private final CreateGoalService createGoalService;
    private final GetGoalListService getGoalListService;
    private final GetGoalListByTeamIdService getGoalListByTeamIdService;
    private final GetGoalDetailService getGoalDetailService;

    @PostMapping
    public void saveGoal(@RequestBody @Valid CreateGoalRequestDto request){
        createGoalService.execute(request);
    }

    @GetMapping("/my")
    public GoalListResponseDto getUserGoal() {
        return getGoalListService.execute();
    }

    @GetMapping("/team/{id}")
    public GoalListResponseDto getUserGoalByTeam(@PathVariable Long id) {
        return getGoalListByTeamIdService.execute(id);
    }

    @GetMapping("/{id}")
    public GoalDetailResponseDto getGoalDetail(@PathVariable Long id) {
        return getGoalDetailService.execute(id);
    }
}

