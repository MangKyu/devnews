package com.mangkyu.devnews.app.accesstoken.issue.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${openapi.token-url}", name = "LoadAuthCodeFeignClient")
interface IssueAccessTokenFeignClient {

    @PostMapping(value = "/oauth2/v2.0/token", consumes = "application/x-www-form-urlencoded")
    IssueAccessTokenFeignResponse issue(
            @ModelAttribute IssueAccessTokenFeignRequest request
    );

}
