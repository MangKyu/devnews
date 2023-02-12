package com.mangkyu.devnews.app.member.add.domain;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.MemberConfiguration;
import com.mangkyu.devnews.app.member.find.domain.FindMemberUseCase;
import com.mangkyu.devnews.app.message.receive.ReceiveMessage;
import com.mangkyu.devnews.app.message.receive.SaveSecretKeyEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@EnableJpaRepositories(basePackageClasses = MemberConfiguration.class)
@EntityScan(basePackageClasses = MemberConfiguration.class)
@AutoConfigureDataJpa
@Transactional
@AutoConfigureCache
@SpringBootTest(classes = MemberConfiguration.class)
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
        String userId = "c72af563-0f21-4736-11e4-045237113344";
        ReceiveMessage message = ReceiveMessage.builder()
                .userId(userId)
                .domainId(1)
                .channelId("jsadpoasdjpo")
                .message("/키등록 secretKey")
                .build();

        SaveSecretKeyEvent event = new SaveSecretKeyEvent(message);

        // when
        eventPublisher.publishEvent(event);

        // then
        assertThat(findMemberUseCase.find(userId)).isNotEmpty();
    }

    @Test
    void 사용자등록이벤트수신_성공_존재하는정보갱신() {
        // given
        String userId = "c72af563-0f21-4736-11e4-045237113344";
        ReceiveMessage message = ReceiveMessage.builder()
                .userId(userId)
                .domainId(1)
                .channelId("channelId")
                .message("/키등록 secretKey")
                .build();

        eventPublisher.publishEvent(new SaveSecretKeyEvent(message));

        String newChannelId = "newChannelId";
        String newSecretKey = "/키등록 newSecretKey";
        ReceiveMessage updateMessage = ReceiveMessage.builder()
                .userId(userId)
                .domainId(1)
                .channelId(newChannelId)
                .message(newSecretKey)
                .build();

        // when
        eventPublisher.publishEvent(new SaveSecretKeyEvent(updateMessage));

        // then
        Optional<Member> result = findMemberUseCase.find(userId);
        assertThat(result).isNotEmpty();

        Member member = result.get();
        assertThat(member.getChannelId()).isEqualTo(newChannelId);
        assertThat(member.getSecretKey()).isEqualTo(newSecretKey);
    }

    @Test
    void 사용자등록_성공_첫등록() {
        // given
        String userId = "c72af563-0f21-4736-11e4-045237113344";

        // when
        useCase.add(userId, 1, "jsadpoasdjpo", "secretKey");

        // then
        assertThat(findMemberUseCase.find(userId)).isNotEmpty();
    }

    @Test
    void 사용자등록_성공_존재하는정보갱신() {
        // given
        String userId = "c72af563-0f21-4736-11e4-045237113344";
        useCase.add(userId, 1, "jsadpoasdjpo", "secretKey");

        // when
        useCase.add(userId, 1, "jsadpoasdjpo", "secretKey");

        // then
        assertThat(findMemberUseCase.find(userId)).isNotEmpty();
    }


}