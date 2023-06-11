package com.ullim.ssomserver.domain.user.domain;

import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.global.entity.BaseTimeEntity;
import com.ullim.ssomserver.global.type.Status;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(length = 14)
    private Status status;

    @Builder
    public User(String email, String nickname, Status status) {
        this.email = email;
        this.nickname = nickname;
        this.status = status;
    }
}
