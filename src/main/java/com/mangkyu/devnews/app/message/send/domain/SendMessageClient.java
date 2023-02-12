package com.mangkyu.devnews.app.message.send.domain;

public interface SendMessageClient {
    void sendToUser(String accessToken, String userId, String message);

    void sendToChannel(String accessToken, String channelId, String message);
}
