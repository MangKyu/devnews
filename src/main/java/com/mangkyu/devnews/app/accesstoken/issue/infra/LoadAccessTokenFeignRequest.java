package com.mangkyu.devnews.app.accesstoken.issue.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoadAccessTokenFeignRequest {

    private String client_id;
    private String client_secret;
    private String grant_type;
    private String scope;
    private String assertion;

}
