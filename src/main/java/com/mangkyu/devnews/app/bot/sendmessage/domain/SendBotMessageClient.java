/*
 *
 *  SendBotMessageClient.java 2022-11-13
 *
 *  Copyright 2022 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.bot.sendmessage.domain;

public interface SendBotMessageClient {
    void send(String accessToken, String userId, String message);
}
