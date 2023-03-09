package com.ullim.ssomserver.domain.team.domain;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.team.domain.type.TeamStatus;
import com.ullim.ssomserver.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "time_join", nullable = false)
    private LocalDate timeJoin;

    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private TeamStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Builder
    public Member(LocalDate timeJoin, TeamStatus status, User user, Team team) {
        this.timeJoin = timeJoin;
        this.status = status;
        this.user = user;
        this.team = team;
    }
}
