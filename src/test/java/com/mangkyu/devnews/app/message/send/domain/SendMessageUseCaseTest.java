package com.mangkyu.devnews.app.message.send.domain;

import com.mangkyu.devnews.app.accesstoken.AccessTokenConfiguration;
import com.mangkyu.devnews.app.accesstoken.issue.domain.IssueAccessTokenUseCase;
import com.mangkyu.devnews.app.message.MessageConfiguration;
import com.mangkyu.devnews.config.properties.PropertiesConfig;
import com.mangkyu.system.TestActiveProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestActiveProfile
@SpringBootTest(classes = {MessageConfiguration.class, AccessTokenConfiguration.class, PropertiesConfig.class})
class SendMessageUseCaseTest {

    @Autowired
    private SendMessageUseCase useCase;


    @Autowired
    private IssueAccessTokenUseCase accessTokenUseCase;

    @Test
    void 메세지전송() {
        // given
        String message = "이것은 메세지입니다.";

        // when
        useCase.send(message);

//        AccessToken result = accessTokenUseCase.issue();
//
//        client.send("Bearer  " + result.getAccessToken(),
//                "minkyu.jo@worksmobile.com");

        // then
    }

}