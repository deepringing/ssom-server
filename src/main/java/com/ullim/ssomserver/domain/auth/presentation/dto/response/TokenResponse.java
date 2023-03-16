package com.ullim.ssomserver.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {

    private String accessToken;
    private String refreshToken;
    private String name;
    private String email;
    private boolean isLogin;
}