package com.mangkyu.devnews.app.message.send.domain;

import com.mangkyu.devnews.system.bean.TestService;

@TestService
class TestSendMessageClient implements SendMessageClient {

    @Override
    public void sendToUser(String accessToken, String userId, String message) {

    }

    @Override
    public void sendToChannel(String accessToken, String channelId, String message) {

    }
}