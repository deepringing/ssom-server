package com.ullim.ssomserver.domain.goal.service;

import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalListResponseDto;
import com.ullim.ssomserver.domain.goal.presentation.dto.response.GoalResponseDto;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetGoalListService {

    private final GoalRepository goalRepository;
    private final UserFacade userFacade;

    @Transactional
    public GoalListResponseDto execute(){
        User user = userFacade.getCurrentUser();

        return new GoalListResponseDto(
                goalRepository.findGoalByUser(user).stream()
                        .map(GoalResponseDto::of)
                        .collect(Collectors.toList())
        );
    }
}
