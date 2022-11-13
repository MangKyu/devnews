package com.mangkyu.devnews.app.accesstoken.issue.infra;

import com.mangkyu.devnews.app.accesstoken.AccessTokenProperties;
import com.mangkyu.devnews.app.accesstoken.issue.domain.AccessToken;
import com.mangkyu.devnews.app.accesstoken.issue.domain.IssueAccessTokenClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class IssueAccessTokenClientFeignAdapter implements IssueAccessTokenClient {

    private final IssueAccessTokenFeignClient feignClient;

    @Override
    public AccessToken issue(AccessTokenProperties accessTokenProperties) {
        IssueAccessTokenFeignResponse response = feignClient.issue(
                toRequest(accessTokenProperties));
        return response.toDomain();
    }

    private IssueAccessTokenFeignRequest toRequest(AccessTokenProperties accessTokenProperties) {
        return IssueAccessTokenFeignRequest.builder()
                .client_id(accessTokenProperties.getClientId())
                .client_secret(accessTokenProperties.getClientSecret())
                .grant_type(accessTokenProperties.getGrantType())
                .scope(accessTokenProperties.getScope())
                .assertion(createAssertion(accessTokenProperties))
                .build();
    }

    private String createAssertion(AccessTokenProperties accessTokenProperties) {
        return TokenUtils.generateJwtToken(accessTokenProperties);
    }

}
