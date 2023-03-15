package com.ullim.ssomserver.domain.auth.presentation;

import com.ullim.ssomserver.domain.auth.domain.RefreshToken;
import com.ullim.ssomserver.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.ullim.ssomserver.domain.auth.presentation.dto.response.TokenResponse;
import com.ullim.ssomserver.domain.auth.service.GoogleAuthLinkService;
import com.ullim.ssomserver.domain.auth.service.GoogleAuthService;
import com.ullim.ssomserver.domain.auth.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final GoogleAuthLinkService googleAuthLinkService;
    private final GoogleAuthService googleAuthService;
    private final RefreshTokenService refreshTokenService;

    @GetMapping("/google")
    public String getGoogleAuthLink() {
        return googleAuthLinkService.execute();
    }

    @PostMapping("/google/callback")
    public TokenResponse authGoogle(@RequestParam String code) {
        return googleAuthService.execute(code);
    }

    @PutMapping
    public AccessTokenResponse refreshToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }

}
