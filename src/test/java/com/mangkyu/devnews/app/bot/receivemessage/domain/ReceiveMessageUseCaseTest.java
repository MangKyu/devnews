package com.mangkyu.devnews.app.bot.receivemessage.domain;

import com.mangkyu.devnews.app.accesstoken.AccessTokenConfiguration;
import com.mangkyu.devnews.app.bot.BotConfiguration;
import com.mangkyu.devnews.app.bot.receivemessage.ReceiveMessage;
import com.mangkyu.devnews.app.bot.receivemessage.ReceiveMessageEvent;
import com.mangkyu.devnews.config.feign.EnableFeignTest;
import com.mangkyu.devnews.config.properties.PropertiesConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

@EnableFeignTest
@SpringBootTest(classes = {BotConfiguration.class, AccessTokenConfiguration.class, PropertiesConfig.class})
class ReceiveMessageUseCaseTest {

    @Autowired
    private ReceiveMessageUseCase useCase;

    @Autowired
    private TestReceiveMessageEventListener eventListener;

    @Test
    void 메세지처리() {
        // given
        ReceiveMessage message = ReceiveMessage.builder()
                .userId("c72af563-0f21-4736-11e4-045237113344")
                .domainId(40029600)
                .channelId("12345a12-b12c-12d3-e123fghijkl")
                .message("hello")
                .build();

        // when
        useCase.handle(message);

        // then
        assertThat(eventListener.isReceived).isTrue();
    }

    @Component
    static class TestReceiveMessageEventListener {

        private boolean isReceived = false;

        @EventListener(ReceiveMessageEvent.class)
        public void listen() {
            this.isReceived = true;
        }
    }

}