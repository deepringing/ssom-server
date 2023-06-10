package com.ullim.ssomserver.domain.todo.service;

import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import com.ullim.ssomserver.domain.todo.facade.TodoFacade;
import com.ullim.ssomserver.global.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CompleteTodoService {

    private final TodoFacade todoFacade;

    @Transactional
    public void execute(Long todoId) {
        Todo todo = todoFacade.findTodoById(todoId);
        todo.toggle();
    }


}
