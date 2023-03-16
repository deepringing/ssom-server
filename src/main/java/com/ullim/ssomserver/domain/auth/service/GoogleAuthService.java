package com.ullim.ssomserver.domain.auth.service;

import com.ullim.ssomserver.domain.auth.presentation.dto.response.TokenResponse;
import com.ullim.ssomserver.domain.user.domain.Repository.UserRepository;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import com.ullim.ssomserver.global.config.properties.AuthProperties;
import com.ullim.ssomserver.global.feign.auth.GoogleAuthClient;
import com.ullim.ssomserver.global.feign.auth.GoogleInformationClient;
import com.ullim.ssomserver.global.feign.auth.dto.request.GoogleAuthRequest;
import com.ullim.ssomserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {

    private final AuthProperties authProperties;
    private final GoogleAuthClient googleAuthClient;
    private final GoogleInformationClient googleInformationClient;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(String code) {
        boolean isLogin = true;
        String accessToken = googleAuthClient.getAccessToken(
                createGoogleAuthRequest(code)).getAccessToken();
        String email = googleInformationClient.getUserInformation(accessToken).getEmail();

        Optional<User> nowUser = userRepository.findByEmail(email);
        User user = null;
        if (nowUser.isEmpty()) {
            isLogin = false;

            user = userRepository.save(
                    User.builder()
                            .email(email)
                            .build()
            );
        } else if (nowUser.get().getName() == null || nowUser.get().getName().equals("")) {
            isLogin = false;
            user = nowUser.get();
        } else {
            user = nowUser.get();
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .email(email)
                .name(user.getName())
                .isLogin(isLogin)
                .build();
    }


    private GoogleAuthRequest createGoogleAuthRequest(String code) {
        return GoogleAuthRequest.builder()
                .code(code)
                .clientId(authProperties.getGoogleClientId())
                .clientSecret(authProperties.getGoogleClientSecret())
                .redirectUri(authProperties.getGoogleRedirectUrl())
                .build();
    }
}