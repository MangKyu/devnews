package com.mangkyu.devnews.app.accesstoken.issue.domain;

import com.mangkyu.devnews.app.accesstoken.AccessTokenProperties;

public interface LoadAccessToken {

    AccessToken issue(AccessTokenProperties accessTokenProperties);

}
