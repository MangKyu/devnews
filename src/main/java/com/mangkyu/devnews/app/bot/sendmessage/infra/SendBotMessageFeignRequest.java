/*
 *
 *  SendBotMessageFeignRequest.java 2022-11-13
 *
 *  Copyright 2022 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.bot.sendmessage.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SendBotMessageFeignRequest {

    private Content content;

    public SendBotMessageFeignRequest(String message) {
        this.content = new Content("text", message);
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Content {
        private String type;
        private String text;
    }

}
