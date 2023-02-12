package com.mangkyu.devnews.app.message.question.domain;

import com.mangkyu.devnews.app.message.MessageTestConfig;
import com.mangkyu.devnews.app.message.receive.QuestionMessageEvent;
import com.mangkyu.devnews.app.message.receive.ReceiveMessage;
import com.mangkyu.devnews.app.message.send.domain.SendMessageUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

@MessageTestConfig
class QuestionMessageUseCaseTest {

    @Autowired
    private QuestionMessageUseCase useCase;

    @Autowired
    private GetQuestionAnswerClient client;

    @Autowired
    private SendMessageUseCase sendMessageUseCase;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Test
    void 질문메세지처리() {
        // given
        QuestionMessageEvent event = questionMessageEvent();

        // when
        publisher.publishEvent(event);

        // then
    }

    private QuestionMessageEvent questionMessageEvent() {
        ReceiveMessage message = ReceiveMessage.builder()
                .userId("c72af563-0f21-4736-11e4-045237113344")
                .domainId(40029600)
                .channelId("12345a12-b12c-12d3-e123fghijkl")
                .message("/질문 질문")
                .build();

        return new QuestionMessageEvent(message);
    }
}