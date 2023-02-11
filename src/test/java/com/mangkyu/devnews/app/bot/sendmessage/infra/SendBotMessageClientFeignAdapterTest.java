package com.mangkyu.devnews.app.bot.sendmessage.infra;

import com.mangkyu.devnews.app.bot.sendmessage.domain.SendBotMessageClient;
import com.mangkyu.devnews.system.bean.TestService;

@TestService
class SendBotMessageClientFeignAdapter implements SendBotMessageClient {

    @Override
    public void send(String accessToken, String userId, String message) {

    }
}