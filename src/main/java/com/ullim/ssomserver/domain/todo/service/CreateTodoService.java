package com.ullim.ssomserver.domain.todo.service;

import com.ullim.ssomserver.domain.team.domain.repository.TeamRepository;
import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import com.ullim.ssomserver.domain.todo.presentation.dto.request.CreateTodoRequestDto;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import com.ullim.ssomserver.global.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTodoService {

    private final TodoRepository todoRepository;
    private final UserFacade userFacade;
    private final TeamRepository teamRepository;

    @Transactional
    public void execute(CreateTodoRequestDto request) {
        User user = userFacade.getCurrentUser();
        Todo todo = Todo.builder()
                .user(user)
                .content(request.getContent())
                .goal(request.getGoal())
                .status(Status.STARTED)
                .build();
        todoRepository.save(todo);
    }



}
