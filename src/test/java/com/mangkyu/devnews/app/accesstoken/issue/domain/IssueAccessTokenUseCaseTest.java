package com.mangkyu.devnews.app.accesstoken.issue.domain;

import com.mangkyu.devnews.app.accesstoken.AccessTokenTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@AccessTokenTestConfig
class IssueAccessTokenUseCaseTest {

    @Autowired
    private IssueAccessTokenUseCase useCase;

    @Test
    void 인증코드발급() {
        // given

        // when
        AccessToken result = useCase.issue();

        // then
        assertThat(result).isNotNull();
    }

}