package com.ullim.ssomserver.domain.user.domain;

import com.ullim.ssomserver.domain.user.domain.type.Gender;
import com.ullim.ssomserver.global.entity.BaseTimeEntity;
import com.ullim.ssomserver.global.type.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Column(length = 20, nullable = false)
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(length = 7, nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(length = 14, nullable = false)
    private Status status;

    @Builder
    public User(String name, String email, String nickname, LocalDate birth, Gender gender, Status status) {
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.status = status;
    }

}
