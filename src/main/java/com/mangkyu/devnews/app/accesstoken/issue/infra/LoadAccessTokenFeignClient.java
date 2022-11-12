package com.mangkyu.devnews.app.accesstoken.issue.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${openapi.url}", name = "LoadAuthCodeFeignClient")
public interface LoadAccessTokenFeignClient {

    @GetMapping("/oauth/2.0/token")
    LoadAccessTokenFeignResponse issue(LoadAccessTokenFeignRequest toRequest);

}
