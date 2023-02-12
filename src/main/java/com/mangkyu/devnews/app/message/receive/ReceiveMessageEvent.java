package com.mangkyu.devnews.app.message.receive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ReceiveMessageEvent {

    @Delegate
    private ReceiveMessage receiveMessage;

}
