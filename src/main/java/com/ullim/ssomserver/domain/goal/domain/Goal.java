package com.ullim.ssomserver.domain.goal.domain;

import com.ullim.ssomserver.domain.goal.domain.type.GoalStatus;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.todo.domain.type.CompleteStatus;
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
@Table(name = "tbl_goal")
public class Goal {


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

    @Column(name = "time_create", nullable = false)
    private LocalDate timeCreate;

    @Column(name = "time_complete", nullable = false)
    private LocalDate timeComplete;

    @Enumerated(EnumType.STRING)
    @Column(name = "complete_status", length = 14, nullable = false)
    private CompleteStatus completeStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private GoalStatus status;

    @Builder
    public Goal(User user, Team team, LocalDate timeCreate, LocalDate timeComplete, CompleteStatus completeStatus, GoalStatus status) {
        this.user = user;
        this.team = team;
        this.timeCreate = timeCreate;
        this.timeComplete = timeComplete;
        this.completeStatus = completeStatus;
        this.status = status;
    }
}
