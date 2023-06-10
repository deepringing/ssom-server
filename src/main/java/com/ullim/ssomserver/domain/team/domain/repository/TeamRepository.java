package com.ullim.ssomserver.domain.team.domain.repository;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findTeamByUser(User user);
    Team findTeamById(Long id);

}
