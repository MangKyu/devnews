/*
 *
 *  QuestionEvent.java 2023-02-12
 *
 *  Copyright 2023 WorksMobile Corp. All rights Reserved.
 *  WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.mangkyu.devnews.app.message.receive;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class QuestionMessageEvent extends ReceiveMessageEvent {
    public QuestionMessageEvent(ReceiveMessage message) {
        super(message);
    }

    public String getQuestion() {
        String message = getMessage().getMessage();
        String[] split = message.split(" ");
        if (ArrayUtils.getLength(split) < 2) {
            return StringUtils.EMPTY;
        }

        return split[1];
    }
}
