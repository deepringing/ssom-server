package com.ullim.ssomserver.domain.todo.domain;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.global.entity.BaseTimeEntity;
import com.ullim.ssomserver.global.type.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_todo")
@Entity
public class Todo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id", nullable = false)
    private Goal goal;


    @Column(name = "complete_time", nullable = false)
    private LocalDateTime CompleteTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private Status status;

    @Builder
    public Todo(User user, Goal goal, LocalDateTime CompleteTime, Status status) {
        this.user = user;
        this.goal = goal;
        this.CompleteTime = CompleteTime;
        this.status = status;
    }
}
