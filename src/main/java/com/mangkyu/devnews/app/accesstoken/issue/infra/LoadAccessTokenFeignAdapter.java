package com.mangkyu.devnews.app.accesstoken.issue.infra;

import com.mangkyu.devnews.app.accesstoken.AccessTokenProperties;
import com.mangkyu.devnews.app.accesstoken.issue.domain.AccessToken;
import com.mangkyu.devnews.app.accesstoken.issue.domain.LoadAccessToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LoadAccessTokenFeignAdapter implements LoadAccessToken {

    private final LoadAccessTokenFeignClient feignClient;

    @Override
    public AccessToken issue(AccessTokenProperties accessTokenProperties) {
        LoadAccessTokenFeignResponse response = feignClient.issue(toRequest(accessTokenProperties));
        return response.toDomain();
    }

    private LoadAccessTokenFeignRequest toRequest(AccessTokenProperties accessTokenProperties) {
        return LoadAccessTokenFeignRequest.builder()
                .client_id(accessTokenProperties.getClientId())
                .client_secret(accessTokenProperties.getClientSecret())
                .grant_type(accessTokenProperties.getGrantType())
                .scope(accessTokenProperties.getScope())
                .assertion(createAssertion(accessTokenProperties))
                .build();
    }

    private String createAssertion(AccessTokenProperties accessTokenProperties) {
        return null;
    }

}
