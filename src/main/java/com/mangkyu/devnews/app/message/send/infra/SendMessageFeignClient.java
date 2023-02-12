/*
 *
 *  SendBotMessageFeignClient.java 2022-11-13
 *
 *  Copyright 2022 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.message.send.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "${openapi.api-url}", name = "SendBotMessageFeignClient")
public interface SendMessageFeignClient {

    @PostMapping("/v1.0/bots/{botId}/users/{userId}/messages")
    void sendToUser(
            @RequestHeader("Authorization") String authorization,
            @PathVariable int botId,
            @PathVariable String userId,
            @RequestBody SendMessageFeignRequest request
    );

    @PostMapping("/v1.0/bots/{botId}/channels/{channelId}/messages")
    void sendToChannel(
            @RequestHeader("Authorization") String authorization,
            @PathVariable int botId,
            @PathVariable String channelId,
            @RequestBody SendMessageFeignRequest request
    );

}
