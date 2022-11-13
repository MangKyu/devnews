package com.mangkyu.devnews.app.accesstoken.issue.domain;

import com.mangkyu.devnews.app.accesstoken.AccessTokenConfiguration;
import com.mangkyu.devnews.config.feign.EnableFeignTest;
import com.mangkyu.devnews.config.properties.PropertiesConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@EnableFeignTest
@SpringBootTest(classes = {AccessTokenConfiguration.class, PropertiesConfig.class})
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