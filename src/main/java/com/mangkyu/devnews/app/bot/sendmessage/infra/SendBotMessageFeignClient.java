/*
 *
 *  SendBotMessageFeignClient.java 2022-11-13
 *
 *  Copyright 2022 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.bot.sendmessage.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "${openapi.api-url}", name = "SendBotMessageFeignClient")
public interface SendBotMessageFeignClient {

    @PostMapping("/v1.0/bots/{botId}/users/{userId}/messages")
    void send(
            @RequestHeader("Authorization") String authorization,
            @PathVariable int botId,
            @PathVariable String userId,
            @RequestBody SendBotMessageFeignRequest request
    );

}
