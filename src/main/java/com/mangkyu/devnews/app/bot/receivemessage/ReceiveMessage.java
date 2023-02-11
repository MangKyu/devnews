package com.mangkyu.devnews.app.bot.receivemessage;

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

    public ReceiveMessageEvent toEvent() {
        return findMessageType();
    }

    private ReceiveMessageEvent findMessageType() {
        if (message.startsWith("/키등록")) {
            return new SaveSecretKeyEvent(ReceiveMessageType.SAVE_SECRET_KEY, this);
        }

        return new TalkEvent(ReceiveMessageType.TALK, this);
    }
}
