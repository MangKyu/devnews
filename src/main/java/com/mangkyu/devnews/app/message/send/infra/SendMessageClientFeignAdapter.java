/*
 *
 *  SendBotMessageClientFeignAdapter.java 2022-11-13
 *
 *  Copyright 2022 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.message.send.infra;

import com.mangkyu.devnews.app.message.MessageProperties;
import com.mangkyu.devnews.app.message.send.domain.SendMessageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SendMessageClientFeignAdapter implements SendMessageClient {

    private final SendMessageFeignClient client;
    private final MessageProperties messageProperties;

    @Override
    public void sendToUser(String accessToken, String userId, String message) {
        client.sendToUser(
                "Bearer " + accessToken,
                messageProperties.getId(),
                userId,
                new SendMessageFeignRequest(message)
        );
    }

    @Override
    public void sendToChannel(String accessToken, String channelId, String message) {
        client.sendToChannel(
                "Bearer " + accessToken,
                messageProperties.getId(),
                channelId,
                new SendMessageFeignRequest(message)
        );
    }
}
