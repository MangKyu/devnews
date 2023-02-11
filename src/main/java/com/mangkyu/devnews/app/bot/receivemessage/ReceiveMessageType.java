package com.mangkyu.devnews.app.bot.receivemessage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReceiveMessageType {

    SAVE_SECRET_KEY("ChatGPT 사용을 위한 secretKey 등록"),
    TALK("대화 메세지"),
    ;

    private final String desc;

}
