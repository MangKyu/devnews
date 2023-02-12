package com.mangkyu.devnews.app.member.add.domain;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.MemberTestConfig;
import com.mangkyu.devnews.app.member.find.domain.FindMemberUseCase;
import com.mangkyu.devnews.app.message.receive.SaveSecretKeyEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static com.mangkyu.devnews.app.member.TestMemberData.member;
import static com.mangkyu.devnews.app.message.TestMessageData.saveSecretKeyEvent;
import static org.assertj.core.api.Assertions.assertThat;

@MemberTestConfig
class AddMemberUseCaseTest {

    @Autowired
    private AddMemberUseCase useCase;
    @Autowired
    private FindMemberUseCase findMemberUseCase;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Test
    void 사용자등록이벤트수신_성공_첫등록() {
        // given
        Member member = member();
        SaveSecretKeyEvent event = saveSecretKeyEvent();

        // when
        eventPublisher.publishEvent(event);

        // then
        assertThat(findMemberUseCase.find(member.getUserId())).isNotEmpty();
    }

    @Test
    void 사용자등록이벤트수신_성공_존재하는정보갱신() {
        // given
        Member member = member();
        eventPublisher.publishEvent(saveSecretKeyEvent());

        String newChannelId = "newChannelId";
        String newSecretKey = "/키등록 newSecretKey";
        SaveSecretKeyEvent event = saveSecretKeyEvent(newChannelId, newSecretKey);

        // when
        eventPublisher.publishEvent(event);

        // then
        Optional<Member> result = findMemberUseCase.find(member.getUserId());
        assertThat(result).isNotEmpty();

        Member resultMember = result.get();
        assertThat(resultMember.getChannelId()).isEqualTo(newChannelId);
        assertThat(resultMember.getSecretKey()).isEqualTo(newSecretKey);
    }

    @Test
    void 사용자등록_성공_첫등록() {
        // given
        Member member = member();

        // when
        useCase.add(member.getUserId(), member.getDomainId(), member.getChannelId(), member.getSecretKey());

        // then
        assertThat(findMemberUseCase.find(member.getUserId())).isNotEmpty();
    }

    @Test
    void 사용자등록_성공_존재하는정보갱신() {
        // given
        Member member = member();
        useCase.add(member.getUserId(), member.getDomainId(), member.getChannelId(), member.getSecretKey());

        // when
        useCase.add(member.getUserId(), member.getDomainId(), member.getChannelId(), member.getSecretKey());

        // then
        assertThat(findMemberUseCase.find(member.getUserId())).isNotEmpty();
    }

}