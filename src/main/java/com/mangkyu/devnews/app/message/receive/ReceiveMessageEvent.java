package com.mangkyu.devnews.app.message.receive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ReceiveMessageEvent {

    private ReceiveMessageType messageType;
    private ReceiveMessage message;

}
