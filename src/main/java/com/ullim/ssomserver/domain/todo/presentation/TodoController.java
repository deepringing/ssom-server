package com.ullim.ssomserver.domain.todo.presentation;

import com.ullim.ssomserver.domain.todo.presentation.dto.request.CreateTodoRequestDto;
import com.ullim.ssomserver.domain.todo.presentation.dto.response.TodoListResponseDto;
import com.ullim.ssomserver.domain.todo.service.CompleteTodoService;
import com.ullim.ssomserver.domain.todo.service.CreateTodoService;
import com.ullim.ssomserver.domain.todo.service.GetTodoListByTeamIdService;
import com.ullim.ssomserver.domain.todo.service.GetTodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final CreateTodoService createTodoService;
    private final GetTodoListService getTodoListService;
    private final GetTodoListByTeamIdService getTodoListByTeamIdService;
    private final CompleteTodoService toggleTodoService;

    @PostMapping
    public void saveTodo(@RequestBody @Valid CreateTodoRequestDto request){
        createTodoService.execute(request);
    }

    @GetMapping("/my")
    public TodoListResponseDto getUserTodo() {
        return getTodoListService.execute();
    }

    @GetMapping("/goal/{id}")
    public TodoListResponseDto getUserTodoByGoal(@PathVariable Long id) {
        return getTodoListByTeamIdService.execute(id);
    }

    @PatchMapping("/{id}/toggle")
    public void completeTodo(@PathVariable Long id) {
        toggleTodoService.execute(id);
    }



}

