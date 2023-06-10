package com.ullim.ssomserver.domain.todo.service;

import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.todo.domain.repository.TodoRepository;
import com.ullim.ssomserver.domain.todo.presentation.dto.response.TodoListResponseDto;
import com.ullim.ssomserver.domain.todo.presentation.dto.response.TodoResponseDto;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetTodoListService {

    private final TodoRepository todoRepository;
    private final UserFacade userFacade;

    @Transactional
    public TodoListResponseDto execute(){
        User user = userFacade.getCurrentUser();

        return new TodoListResponseDto(
                todoRepository.findTodoByUser(user).stream()
                        .map(this::createTodoResponse)
                        .collect(Collectors.toList())
        );
    }

    private TodoResponseDto createTodoResponse(Todo todo){
        return TodoResponseDto.of(todo);
    }

}
