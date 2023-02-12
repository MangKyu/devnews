package com.mangkyu.devnews.app.message.receive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionMessageEventTest {


    @MethodSource("question")
    @ParameterizedTest
    void question조회(String message, String question) {
        // given
        QuestionMessageEvent event = questionMessageEvent(message);

        // when
        String result = event.getQuestion();

        // then
        assertThat(result).isEqualTo(question);
    }

    private QuestionMessageEvent questionMessageEvent(String message) {
        return new QuestionMessageEvent(ReceiveMessage.builder().message(message).build());
    }

    private static List<Arguments> question() {
        return List.of(
                Arguments.of("/질문 질문이요", "질문이요"),
                Arguments.of("/질문 질문이요 질문이요", "질문이요"),
                Arguments.of("/질문", "")
        );

    }

}