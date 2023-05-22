package com.ullim.ssomserver.domain.user.service;

import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import com.ullim.ssomserver.domain.user.presentation.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GetUserInformation {

    private final UserFacade userFacade;

    @Transactional
    public UserResponseDto execute() {
        User user = userFacade.getCurrentUser();
        return UserResponseDto.of(user);
    }

}
