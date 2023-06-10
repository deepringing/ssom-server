package com.ullim.ssomserver.domain.team.presentation.dto.request;

import com.ullim.ssomserver.domain.team.domain.Team;
import com.ullim.ssomserver.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberRequestDto {

    @NotNull
    private User user;

    @NotNull
    private Team team;

}
