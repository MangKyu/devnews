package com.mangkyu.devnews.app.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    void member정보갱신() {
        // given
        String newChannelId = "newChannelId";
        String newSecretKey = "newSecretKey";

        Member member = Member.builder()
                .channelId("jsadpoasdjpo")
                .secretKey("secretKey")
                .build();

        // when
        member.update(newChannelId, newSecretKey);

        // then
        assertThat(member.getChannelId()).isEqualTo(newChannelId);
        assertThat(member.getSecretKey()).isEqualTo(newSecretKey);
    }

}