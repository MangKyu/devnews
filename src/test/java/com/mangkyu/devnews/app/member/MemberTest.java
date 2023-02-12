package com.mangkyu.devnews.app.member;

import org.junit.jupiter.api.Test;

import static com.mangkyu.devnews.app.member.TestMemberData.member;
import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    void member정보갱신() {
        // given
        String newChannelId = "newChannelId";
        String newSecretKey = "newSecretKey";
        Member member = member();


        // when
        member.update(newChannelId, newSecretKey);

        // then
        assertThat(member.getChannelId()).isEqualTo(newChannelId);
        assertThat(member.getSecretKey()).isEqualTo(newSecretKey);
    }

}