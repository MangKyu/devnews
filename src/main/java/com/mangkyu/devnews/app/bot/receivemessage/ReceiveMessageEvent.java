package com.mangkyu.devnews.app.bot.receivemessage;

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
