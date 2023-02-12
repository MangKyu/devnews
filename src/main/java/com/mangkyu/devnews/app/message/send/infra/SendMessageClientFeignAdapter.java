package com.mangkyu.devnews.app.message.send.infra;

import com.mangkyu.devnews.app.message.MessageProperties;
import com.mangkyu.devnews.app.message.send.domain.SendMessageClient;
import com.mangkyu.devnews.system.bean.RealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RealService
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
