package com.ullim.ssomserver.domain.team.domain.repository;

import com.ullim.ssomserver.domain.team.domain.Member;
import com.ullim.ssomserver.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUser(User user);
}
