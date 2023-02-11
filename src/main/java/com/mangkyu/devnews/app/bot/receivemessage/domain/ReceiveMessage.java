package com.mangkyu.devnews.app.bot.receivemessage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveMessage {

    private String userId;
    private int domainId;
    private String channelId;
    private String message;

}
