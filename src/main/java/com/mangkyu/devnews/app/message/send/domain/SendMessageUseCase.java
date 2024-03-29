package com.mangkyu.devnews.app.message.send.domain;

import com.mangkyu.devnews.app.accesstoken.issue.domain.AccessToken;
import com.mangkyu.devnews.app.accesstoken.issue.domain.IssueAccessTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendMessageUseCase {

    private final IssueAccessTokenUseCase issueAccessTokenUseCase;
    private final SendMessageClient sendMessageClient;

    public void send(String message, String channelId) {
        AccessToken accessToken = issueAccessTokenUseCase.issue();
        sendMessageClient.sendToChannel(accessToken.getAccessToken(), channelId, message);
    }

}
