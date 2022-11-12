package com.mangkyu.devnews.app.accesstoken.issue.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${openapi.url}", name = "LoadAuthCodeFeignClient")
public interface LoadAccessTokenFeignClient {

    @PostMapping("/oauth/2.0/token")
    LoadAccessTokenFeignResponse issue(@RequestBody LoadAccessTokenFeignRequest toRequest);

}
