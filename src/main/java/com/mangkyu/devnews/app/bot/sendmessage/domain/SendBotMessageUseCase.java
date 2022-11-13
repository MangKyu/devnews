/*
 *
 *  SendBotMessageUseCase.java 2022-11-13
 *
 *  Copyright 2022 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.bot.sendmessage.domain;

import com.mangkyu.devnews.app.accesstoken.issue.domain.AccessToken;
import com.mangkyu.devnews.app.accesstoken.issue.domain.IssueAccessTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendBotMessageUseCase {

    private final IssueAccessTokenUseCase issueAccessTokenUseCase;
    private final SendBotMessageClient sendBotMessageClient;

    public void send(String message) {
        AccessToken accessToken = issueAccessTokenUseCase.issue();
        sendBotMessageClient.send(accessToken.getAccessToken(), "d5a47dae-79ef-48d9-15b2-014ba89c70fb", message);
    }
}
