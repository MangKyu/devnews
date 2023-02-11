package com.mangkyu.devnews.app.bot.receivemessage;

public class TalkEvent extends ReceiveMessageEvent {

    public TalkEvent(ReceiveMessageType messageType, ReceiveMessage message) {
        super(messageType, message);
    }
}
