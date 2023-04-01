package com.ullim.ssomserver.domain.goal.presentation;

import com.ullim.ssomserver.domain.goal.presentation.dto.request.CreateGoalRequestDto;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalListResponseDto;
import com.ullim.ssomserver.domain.goal.service.CreateGoalService;
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

    @PostMapping
    public void saveGoal(@RequestBody @Valid CreateGoalRequestDto request){
        createGoalService.execute(request);
    }

    @GetMapping("/my")
    public GoalListResponseDto getUserGoal() {
        return getGoalListService.execute();
    }


}

