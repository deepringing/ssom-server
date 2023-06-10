package com.ullim.ssomserver.domain.todo.exception;

import com.ullim.ssomserver.domain.todo.exception.error.TodoErrorProperty;
import com.ullim.ssomserver.global.error.exception.SsomException;

public class TodoNotFoundException extends SsomException {
    public final static SsomException EXCEPTION = new TodoNotFoundException();

    private TodoNotFoundException() {
        super(TodoErrorProperty.GOAL_NOT_FOUND);
    }
}
