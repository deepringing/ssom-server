package com.ullim.ssomserver.domain.todo.domain;

import com.ullim.ssomserver.domain.goal.domain.Goal;
import com.ullim.ssomserver.domain.todo.domain.type.CompleteStatus;
import com.ullim.ssomserver.domain.todo.domain.type.TodoStatus;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_todo")
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

    @Column(name = "time_create", nullable = false)
    private LocalDate timeCreate;

    @Column(name = "time_complete", nullable = false)
    private LocalDate timeComplete;

    @Enumerated(EnumType.STRING)
    @Column(name = "complete_status", length = 14, nullable = false)
    private CompleteStatus completeStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private TodoStatus status;

    @Builder
    public Todo(User user, Goal goal, LocalDate timeCreate, LocalDate timeComplete, CompleteStatus completeStatus, TodoStatus status) {
        this.user = user;
        this.goal = goal;
        this.timeCreate = timeCreate;
        this.timeComplete = timeComplete;
        this.completeStatus = completeStatus;
        this.status = status;
    }
}
