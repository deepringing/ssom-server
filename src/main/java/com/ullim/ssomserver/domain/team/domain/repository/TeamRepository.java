package com.ullim.ssomserver.domain.team.domain.repository;

import com.ullim.ssomserver.domain.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamById(Long id);

}
