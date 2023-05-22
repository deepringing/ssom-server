package com.ullim.ssomserver.domain.user.presentation;

import com.ullim.ssomserver.domain.user.presentation.dto.response.UserResponseDto;
import com.ullim.ssomserver.domain.user.service.GetUserInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final GetUserInformation getUserInformation;

    @GetMapping
    public UserResponseDto getUser() {
        return getUserInformation.execute();
    }

//    @PutMapping
//    public void updateStatus() {
//        return updateUserStatus.execute();
//    }

}
