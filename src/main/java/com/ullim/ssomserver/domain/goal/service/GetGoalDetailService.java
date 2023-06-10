package com.ullim.ssomserver.domain.goal.service;

import com.ullim.ssomserver.domain.goal.facade.GoalFacade;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GetGoalDetailService {

    private final GoalFacade goalFacade;

    @Transactional
    public GoalDetailResponseDto execute(Long id){

        return GoalDetailResponseDto.of(
                goalFacade.findGoalById(id));
    }
}
