package com.ullim.ssomserver.domain.team.domain;

import com.ullim.ssomserver.global.entity.BaseTimeEntity;
import com.ullim.ssomserver.global.type.Status;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_team")
@Entity
public class Team extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String teamName;


    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private Status status;


    @Builder
    public Team(String teamName, Status status) {
        this.teamName = teamName;
        this.status = status;
    }

}
