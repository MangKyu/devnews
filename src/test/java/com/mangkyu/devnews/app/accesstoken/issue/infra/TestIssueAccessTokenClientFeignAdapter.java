package com.mangkyu.devnews.app.accesstoken.issue.infra;

import com.mangkyu.devnews.app.accesstoken.AccessTokenProperties;
import com.mangkyu.devnews.app.accesstoken.issue.domain.AccessToken;
import com.mangkyu.devnews.app.accesstoken.issue.domain.IssueAccessTokenClient;
import com.mangkyu.devnews.system.bean.TestService;

@TestService
class TestIssueAccessTokenClientFeignAdapter implements IssueAccessTokenClient {

    @Override
    public AccessToken issue(AccessTokenProperties accessTokenProperties) {
        return new AccessToken();
    }
}