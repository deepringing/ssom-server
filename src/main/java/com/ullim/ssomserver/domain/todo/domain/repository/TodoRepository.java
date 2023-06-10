package com.ullim.ssomserver.domain.todo.domain.repository;

import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findTodoByUser(User user);

    List<Todo> findTodoByTeamId(Long team_id);

}
