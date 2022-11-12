package com.mangkyu.devnews.app.accesstoken.issue.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${openapi.token-url}", name = "LoadAuthCodeFeignClient")
public interface LoadAccessTokenFeignClient {


    @PostMapping(value = "/oauth2/v2.0/token", consumes = "application/x-www-form-urlencoded")
    LoadAccessTokenFeignResponse issue(
            @ModelAttribute LoadAccessTokenFeignRequest request
    );

}
