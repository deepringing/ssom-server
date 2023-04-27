package com.ullim.ssomserver.domain.team.domain.repository;

import com.ullim.ssomserver.domain.team.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
