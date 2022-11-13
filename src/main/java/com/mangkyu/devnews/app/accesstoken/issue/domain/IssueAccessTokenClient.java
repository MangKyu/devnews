package com.mangkyu.devnews.app.accesstoken.issue.domain;

import com.mangkyu.devnews.app.accesstoken.AccessTokenProperties;

public interface IssueAccessTokenClient {

    AccessToken issue(AccessTokenProperties accessTokenProperties);

}
