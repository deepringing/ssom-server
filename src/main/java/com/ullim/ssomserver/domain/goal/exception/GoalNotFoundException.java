package com.ullim.ssomserver.domain.goal.exception;

import com.ullim.ssomserver.domain.goal.exception.error.GoalErrorProperty;
import com.ullim.ssomserver.global.error.exception.SsomException;

public class GoalNotFoundException extends SsomException {
    public final static SsomException EXCEPTION = new GoalNotFoundException();

    private GoalNotFoundException() {
        super(GoalErrorProperty.GOAL_NOT_FOUND);
    }
}
