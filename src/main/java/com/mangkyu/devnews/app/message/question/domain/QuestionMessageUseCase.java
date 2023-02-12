package com.mangkyu.devnews.app.message.question.domain;


import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.find.domain.FindMemberUseCase;
import com.mangkyu.devnews.app.message.receive.QuestionMessageEvent;
import com.mangkyu.devnews.app.message.send.domain.SendMessageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionMessageUseCase {

    private final GetQuestionAnswerClient client;
    private final SendMessageUseCase sendMessageUseCase;
    private final FindMemberUseCase findMemberUseCase;

    @EventListener(QuestionMessageEvent.class)
    public void process(QuestionMessageEvent event) {
        Member member = findMemberUseCase.findByUserId(event.getUserId());
        String answer = client.getAnswer(event.getQuestion(), member.getSecretKey());
        sendMessageUseCase.send(answer, event.getChannelId());
    }

}
