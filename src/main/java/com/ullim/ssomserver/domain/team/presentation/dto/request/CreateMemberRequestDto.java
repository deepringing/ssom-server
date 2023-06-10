package com.ullim.ssomserver.domain.team.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberRequestDto {

    @NotNull
    private String email;

    @NotNull
    private Long teamId;

}
