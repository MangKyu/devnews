package com.mangkyu.devnews.app.bot.receivemessage.domain;

import com.mangkyu.devnews.app.bot.receivemessage.ReceiveMessage;
import com.mangkyu.devnews.app.bot.receivemessage.ReceiveMessageEvent;
import com.mangkyu.devnews.app.bot.receivemessage.SaveSecretKeyEvent;
import com.mangkyu.devnews.app.bot.receivemessage.TalkEvent;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiveMessageTest {

    @MethodSource("messageType")
    @ParameterizedTest
    void 이벤트객체로변환(String text, Class<ReceiveMessageEvent> eventClass) {
        // given
        ReceiveMessage receiveMessage = ReceiveMessage.builder()
                .message(text)
                .build();

        // when
        ReceiveMessageEvent result = receiveMessage.toEvent();

        // then
        assertThat(result).isInstanceOf(eventClass);
    }

    public static List<Arguments> messageType() {
        return List.of(
                Arguments.of("/키등록 secretKey", SaveSecretKeyEvent.class),
                Arguments.of("hello", TalkEvent.class)
        );
    }
}