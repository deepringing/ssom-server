package com.ullim.ssomserver.domain.goal.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goal")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;

}

