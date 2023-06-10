package com.ullim.ssomserver.domain.team.presentation;

import com.ullim.ssomserver.domain.team.presentation.dto.request.CreateMemberRequestDto;
import com.ullim.ssomserver.domain.team.service.CreateMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final CreateMemberService createMemberService;

    @PostMapping
    public void saveMember(@RequestBody @Valid CreateMemberRequestDto request) {
        createMemberService.execute(request);
    }

}
