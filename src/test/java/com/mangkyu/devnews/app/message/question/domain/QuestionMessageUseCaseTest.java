package com.mangkyu.devnews.app.message.question.domain;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.add.domain.AddMemberUseCase;
import com.mangkyu.devnews.app.message.MessageTestConfig;
import com.mangkyu.devnews.app.message.receive.QuestionMessageEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import static com.mangkyu.devnews.app.member.TestMemberData.member;
import static com.mangkyu.devnews.app.message.TestMessageData.questionMessageEvent;

@MessageTestConfig
class QuestionMessageUseCaseTest {

    @Autowired
    private AddMemberUseCase addMemberUseCase;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Test
    void 질문메세지처리() {
        // given
        Member member = member();
        addMemberUseCase.add(member.getUserId(), member.getDomainId(), member.getChannelId(), member.getSecretKey());

        QuestionMessageEvent event = questionMessageEvent();

        // when
        publisher.publishEvent(event);

        // then
    }

}