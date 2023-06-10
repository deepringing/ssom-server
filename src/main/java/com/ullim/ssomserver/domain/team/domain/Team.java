package com.ullim.ssomserver.domain.team.domain;

import com.ullim.ssomserver.global.entity.BaseTimeEntity;
import com.ullim.ssomserver.global.type.Status;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_team")
@Entity
public class Team extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(length = 14)
    private Status status;

    @OneToMany(mappedBy = "team")
    private List<Member> memberList = new ArrayList<>();

    @Builder
    public Team(String name, Status status) {
        this.name = name;
        this.status = status;
    }

}
