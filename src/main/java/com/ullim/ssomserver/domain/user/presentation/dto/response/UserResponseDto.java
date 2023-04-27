package com.ullim.ssomserver.domain.user.presentation.dto.response;

import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.domain.type.Gender;
import com.ullim.ssomserver.global.type.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class UserResponseDto {

    private Long id;
    private String email;
    private String nickname;
    private Status status;

    public static UserResponseDto of(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .status(user.getStatus())
                .build();
    }

}