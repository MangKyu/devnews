package com.mangkyu.devnews.app.message.send.infra;

import com.mangkyu.devnews.app.message.send.domain.SendMessageClient;
import com.mangkyu.devnews.system.bean.TestService;

@TestService
class SendMessageClientFeignAdapter implements SendMessageClient {

    @Override
    public void send(String accessToken, String userId, String message) {

    }
}