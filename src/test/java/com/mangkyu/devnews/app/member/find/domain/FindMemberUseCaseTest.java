package com.mangkyu.devnews.app.member.find.domain;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.MemberTestConfig;
import com.mangkyu.devnews.app.member.add.domain.AddMemberUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.mangkyu.devnews.app.member.TestMemberData.member;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@MemberTestConfig
class FindMemberUseCaseTest {

    @Autowired
    private FindMemberUseCase useCase;

    @Autowired
    private AddMemberUseCase addMemberUseCase;

    @Test
    void 사용자찾기_없음_Optinal반환() {
        // given
        Member member = member();

        // when
        Optional<Member> result = useCase.find(member.getUserId());

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void 등록된사용자찾기_없음_에러반환() {
        // given
        Member member = member();

        // when
        assertThatThrownBy(() -> useCase.findByUserId(member.getUserId()))
                .isInstanceOf(IllegalStateException.class);

        // then
    }

    @Test
    void 등록된사용자찾기_있음() {
        // given
        Member member = member();
        addMemberUseCase.add(member.getUserId(), member.getDomainId(), member.getChannelId(), member.getSecretKey());

        // when
        Member result = useCase.findByUserId(member.getUserId());

        // then
        assertThat(result).isNotNull();
    }

}
