package com.ullim.ssomserver.domain.auth.service;

import com.ullim.ssomserver.domain.auth.presentation.dto.response.TokenResponse;
import com.ullim.ssomserver.domain.user.domain.Repository.UserRepository;
import com.ullim.ssomserver.domain.user.domain.User;
import com.ullim.ssomserver.domain.user.facade.UserFacade;
import com.ullim.ssomserver.global.config.properties.AuthProperties;
import com.ullim.ssomserver.global.feign.auth.GoogleAuthClient;
import com.ullim.ssomserver.global.feign.auth.GoogleInformationClient;
import com.ullim.ssomserver.global.feign.auth.dto.request.GoogleAuthRequest;
import com.ullim.ssomserver.global.feign.auth.dto.response.GoogleInformationResponse;
import com.ullim.ssomserver.global.security.jwt.JwtTokenProvider;
import com.ullim.ssomserver.global.type.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
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
        String accessToken = googleAuthClient.getAccessToken(
                createGoogleAuthRequest(code)).getAccessToken();
        GoogleInformationResponse information = googleInformationClient.getUserInformation(accessToken);

        Optional<User> user = userRepository.findByEmail(information.getEmail());

        if (user.isEmpty()) {
            user = Optional.of(userRepository.save(
                    User.builder()
                            .nickname(information.getName())
                            .email(information.getEmail())
                            .status(Status.STARTED)
                            .build()
            ));
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(information.getEmail()))
                .refreshToken(jwtTokenProvider.createRefreshToken(information.getEmail()))
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