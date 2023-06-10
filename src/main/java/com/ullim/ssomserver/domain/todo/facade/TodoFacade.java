package com.ullim.ssomserver.domain.todo.facade;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.goal.domain.repository.GoalRepository;
import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import com.ullim.ssomserver.domain.todo.exception.TodoNotFoundException;
import com.ullim.ssomserver.global.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoFacade {

    private final TodoRepository todoRepository;

    public Todo findTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> TodoNotFoundException.EXCEPTION);
        if (todo.getStatus() == Status.DELETED)
            throw TodoNotFoundException.EXCEPTION;
        return todo;
    }

}
