package com.ullim.ssomserver.domain.goal.domain.repository;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findGoalByUser(User user);

    List<Goal> findGoalByTeam(Team team);
}
