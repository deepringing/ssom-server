package com.ullim.ssomserver.domain.goal.domain;

import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.global.entity.BaseTimeEntity;
import com.ullim.ssomserver.global.type.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_goal")
public class Goal extends BaseTimeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;


    @Column(name = "complete_time", nullable = false)
    private LocalDate CompleteTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private Status status;

    @Builder
    public Goal(User user, Team team, LocalDate timeCreate, LocalDate completeTime, Status status) {
        this.user = user;
        this.team = team;
        this.CompleteTime = completeTime;
        this.status = status;
    }
}
