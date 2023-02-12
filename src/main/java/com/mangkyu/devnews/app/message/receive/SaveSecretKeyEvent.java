package com.mangkyu.devnews.app.message.receive;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class SaveSecretKeyEvent extends ReceiveMessageEvent {

    public SaveSecretKeyEvent(ReceiveMessage message) {
        super(message);
    }

    public String getSecretKey() {
        String message = getMessage();
        String[] split = message.split(" ");
        if (ArrayUtils.getLength(split) < 2) {
            return StringUtils.EMPTY;
        }

        return split[1];
    }
}
