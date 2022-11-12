package com.mangkyu.devnews.app.accesstoken.issue.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {

    private String accessToken;
    private String refreshToken;

}
