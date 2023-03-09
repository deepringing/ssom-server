package com.ullim.ssomserver.domain.team.domain;

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
@Table(name = "tbl_team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "time_create", nullable = false)
    private LocalDate timeCreate;

    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private TeamStatus status;


    @Builder
    public Team(String teamName, LocalDate timeCreate, TeamStatus status, User user, Team team) {
        this.teamName = teamName;
        this.timeCreate = timeCreate;
        this.status = status;
    }

}
