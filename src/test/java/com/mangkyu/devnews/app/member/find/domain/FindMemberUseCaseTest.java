package com.mangkyu.devnews.app.member.find.domain;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.MemberConfiguration;
import com.mangkyu.devnews.app.member.add.domain.AddMemberUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@EnableJpaRepositories(basePackageClasses = MemberConfiguration.class)
@EntityScan(basePackageClasses = MemberConfiguration.class)
@AutoConfigureDataJpa
@Transactional
@AutoConfigureCache
@SpringBootTest(classes = MemberConfiguration.class)
class FindMemberUseCaseTest {

    @Autowired
    private FindMemberUseCase useCase;

    @Autowired
    private AddMemberUseCase addMemberUseCase;

    @Test
    void 사용자찾기_없음_Optinal반환() {
        // given
        String userId = "c72af563-0f21-4736-11e4-045237113344";

        // when
        Optional<Member> result = useCase.find(userId);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void 등록된사용자찾기_없음_에러반환() {
        // given
        String userId = "c72af563-0f21-4736-11e4-045237113344";

        // when
        assertThatThrownBy(() -> useCase.findByUserId(userId))
                .isInstanceOf(IllegalStateException.class);

        // then
    }

    @Test
    void 등록된사용자찾기_있음() {
        // given
        String userId = "c72af563-0f21-4736-11e4-045237113344";
        addMemberUseCase.add(userId, 1, "jsadpoasdjpo", "secretKey");

        // when
        Member result = useCase.findByUserId(userId);

        // then
        assertThat(result).isNotNull();
    }

}
