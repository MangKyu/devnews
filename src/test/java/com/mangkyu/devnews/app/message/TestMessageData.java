package com.mangkyu.devnews.app.message;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.message.receive.QuestionMessageEvent;
import com.mangkyu.devnews.app.message.receive.ReceiveMessage;
import com.mangkyu.devnews.app.message.receive.SaveSecretKeyEvent;

import static com.mangkyu.devnews.app.member.TestMemberData.member;

public class TestMessageData {

    public static SaveSecretKeyEvent saveSecretKeyEvent() {
        Member member = member();
        ReceiveMessage message = ReceiveMessage.builder()
                .userId(member.getUserId())
                .domainId(member.getDomainId())
                .channelId(member.getChannelId())
                .message("/키등록 secretKey")
                .build();

        return new SaveSecretKeyEvent(message);
    }

    public static SaveSecretKeyEvent saveSecretKeyEvent(String channelId, String message) {
        Member member = member();
        ReceiveMessage receiveMessage = ReceiveMessage.builder()
                .userId(member.getUserId())
                .domainId(member.getDomainId())
                .channelId(channelId)
                .message(message)
                .build();

        return new SaveSecretKeyEvent(receiveMessage);
    }

    public static QuestionMessageEvent questionMessageEvent() {
        Member member = member();
        ReceiveMessage message = ReceiveMessage.builder()
                .userId(member.getUserId())
                .domainId(member.getDomainId())
                .channelId(member.getChannelId())
                .message("/질문 질문")
                .build();

        return new QuestionMessageEvent(message);
    }
}
