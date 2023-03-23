package com.ullim.ssomserver.domain.goal.exception.error;

import com.ullim.ssomserver.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoalErrorProperty implements ErrorProperty {

    GOAL_NOT_FOUND(404, "목표를 찾을 수 없습니다.");

    private final int status;
    private final String message;

}
