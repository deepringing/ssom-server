package com.ullim.ssomserver.global.feign.auth;

import com.ullim.ssomserver.global.feign.auth.dto.request.GoogleAuthRequest;
import com.ullim.ssomserver.global.feign.auth.dto.response.GoogleTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "GoogleAuthClient", url = "https://oauth2.googleapis.com/token")
public interface GoogleAuthClient {

    @PostMapping
    public GoogleTokenResponse getAccessToken(GoogleAuthRequest request);

}
