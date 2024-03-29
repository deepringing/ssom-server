package com.ullim.ssomserver.domain.auth.service;


import com.ullim.ssomserver.global.config.properties.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleAuthLinkService {

    private static final String QUERY_STRING = "?client_id=%s&redirect_uri=%s&response_type=code&" +
            "scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";

    private final AuthProperties authProperties;

    public String execute() {
        return authProperties.getGoogleBaseUrl() +
                String.format(QUERY_STRING, authProperties.getGoogleClientId(), authProperties.getGoogleRedirectUrl());
    }
}
