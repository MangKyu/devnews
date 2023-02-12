package com.mangkyu.devnews.app.message.receive;

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
            return new SaveSecretKeyEvent(this);
        }

        if (message.startsWith("/질문")) {
            return new QuestionMessageEvent(this);
        }

        return new TalkEvent(this);
    }
}
