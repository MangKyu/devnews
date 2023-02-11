package com.mangkyu.devnews.app.member.add.domain;

import com.mangkyu.devnews.app.member.MemberConfiguration;
import com.mangkyu.devnews.app.member.find.domain.FindMemberUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

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

    @Test
    void 사용자등록_성공() {
        // given
        String userId = "c72af563-0f21-4736-11e4-045237113344";

        // when
        useCase.add(userId, 1, "jsadpoasdjpo", "secretKey");

        // then
        assertThat(findMemberUseCase.find(userId)).isNotEmpty();
    }


}