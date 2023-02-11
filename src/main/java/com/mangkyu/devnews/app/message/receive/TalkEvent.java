package com.mangkyu.devnews.app.message.receive;

public class TalkEvent extends ReceiveMessageEvent {

    public TalkEvent(ReceiveMessageType messageType, ReceiveMessage message) {
        super(messageType, message);
    }
}
