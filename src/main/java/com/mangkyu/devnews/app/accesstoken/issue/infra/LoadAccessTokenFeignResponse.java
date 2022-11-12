package com.mangkyu.devnews.app.accesstoken.issue.infra;

import com.mangkyu.devnews.app.accesstoken.issue.domain.AccessToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoadAccessTokenFeignResponse {

    private String access_token;
    private String refresh_token;
    private String token_type;
    private String expires_in;
    private String scope;

    public AccessToken toDomain() {
        return AccessToken.builder()
                .accessToken(access_token)
                .refreshToken(refresh_token)
                .build();
    }
}
