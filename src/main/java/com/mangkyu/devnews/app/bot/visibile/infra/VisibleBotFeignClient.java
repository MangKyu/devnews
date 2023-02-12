package com.mangkyu.devnews.app.bot.visibile.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(url = "${openapi.api-url}", name = "LoadBotListFeignClient")
interface VisibleBotFeignClient {

    @PutMapping("/v1.0/bots/{botId}/domains/{domainId}")
    void visibleBotOnDomain(
            @RequestHeader("Authorization") String authorization,
            @PathVariable String botId,
            @PathVariable String domainId,
            @RequestBody Map<String, Boolean> visible
    );

}
