package com.ullim.ssomserver.domain.goal.domain.repository;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {


}
