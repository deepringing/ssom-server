package com.ullim.ssomserver.domain.auth.service;

import com.ullim.ssomserver.domain.auth.domain.RefreshToken;
import com.ullim.ssomserver.domain.auth.domain.repository.RefreshTokenRepository;
import com.ullim.ssomserver.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.ullim.ssomserver.global.security.jwt.JwtTokenProvider;
import com.ullim.ssomserver.global.security.jwt.exception.ExpiredTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = getRefreshToken(token);
        return AccessTokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(refreshToken.getEmail()))
                .build();
    }

    private RefreshToken getRefreshToken(String token) {
        return refreshTokenRepository.findById(token)
                .orElseThrow(() -> ExpiredTokenException.EXCEPTION);
    }

}
