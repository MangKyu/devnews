package com.mangkyu.devnews.app.message.receive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SaveSecretKeyEventTest {

    @MethodSource("secretKey")
    @ParameterizedTest
    void secretKey조회(String message, String secretKey) {
        // given
        SaveSecretKeyEvent event = saveSecretKeyEvent(message);

        // when
        String result = event.getSecretKey();

        // then
        assertThat(result).isEqualTo(secretKey);
    }

    private SaveSecretKeyEvent saveSecretKeyEvent(String message) {
        return new SaveSecretKeyEvent(ReceiveMessage.builder().message(message).build());
    }

    private static List<Arguments> secretKey() {
        return List.of(
                Arguments.of("/키등록 secretKey", "secretKey"),
                Arguments.of("/키등록 secretKey secretKey", "secretKey"),
                Arguments.of("/키등록", "")
        );

    }

}