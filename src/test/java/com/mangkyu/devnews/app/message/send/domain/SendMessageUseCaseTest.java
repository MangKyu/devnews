package com.mangkyu.devnews.app.message.send.domain;

import com.mangkyu.devnews.app.accesstoken.issue.domain.IssueAccessTokenUseCase;
import com.mangkyu.devnews.app.message.MessageTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@MessageTestConfig
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
        useCase.send(message, "d5a47dae-79ef-48d9-15b2-014ba89c70fb");

//        AccessToken result = accessTokenUseCase.issue();
//
//        client.send("Bearer  " + result.getAccessToken(),
//                "minkyu.jo@worksmobile.com");

        // then
    }

}