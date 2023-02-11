package com.mangkyu.devnews.app.message.receive;

public class SaveSecretKeyEvent extends ReceiveMessageEvent {

    public SaveSecretKeyEvent(ReceiveMessageType messageType, ReceiveMessage message) {
        super(messageType, message);
    }
}
