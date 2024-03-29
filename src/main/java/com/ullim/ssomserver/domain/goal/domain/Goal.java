package com.ullim.ssomserver.domain.goal.domain;

import com.ullim.ssomserver.domain.goal.domain.type.GoalType;
import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.todo.domain.Todo;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.global.entity.BaseTimeEntity;
import com.ullim.ssomserver.global.type.Status;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_goal")
@Entity
public class Goal extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long id;

    @Column(nullable = true)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team", nullable = true)
    private Team team;

    @Column(name = "completed_at", nullable = true)
    private LocalDate completedAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 14)
    private Status status;

    @OneToMany(mappedBy = "goal")
    private List<Todo> todoList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private GoalType type;

    @Builder
    public Goal(String content, LocalDate completedAt, User user, Team team, GoalType type) {
        this.content = content;
        this.completedAt = completedAt;
        this.user = user;
        this.team = team;
        this.status = Status.STARTED;
        this.type = type;
    }
}
