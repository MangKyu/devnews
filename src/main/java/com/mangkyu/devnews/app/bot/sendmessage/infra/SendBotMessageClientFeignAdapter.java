/*
 *
 *  SendBotMessageClientFeignAdapter.java 2022-11-13
 *
 *  Copyright 2022 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.bot.sendmessage.infra;

import com.mangkyu.devnews.app.bot.BotProperties;
import com.mangkyu.devnews.app.bot.sendmessage.domain.SendBotMessageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SendBotMessageClientFeignAdapter implements SendBotMessageClient {

    private final SendBotMessageFeignClient client;
    private final BotProperties botProperties;

    @Override
    public void send(String accessToken, String userId, String message) {
        client.send(
                "Bearer " + accessToken,
                botProperties.getId(),
                userId,
                new SendBotMessageFeignRequest(message)
        );
    }
}
