package com.mangkyu.devnews.app.accesstoken.issue.domain;

import com.mangkyu.devnews.app.accesstoken.AccessTokenProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueAccessTokenUseCase {

    private final IssueAccessTokenClient authCodeClient;
    private final AccessTokenProperties accessTokenProperties;

    public AccessToken issue() {
        return authCodeClient.issue(accessTokenProperties);
    }
}
