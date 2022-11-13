package com.mangkyu.devnews.app.bot.sendmessage.domain;

import com.mangkyu.devnews.app.accesstoken.AccessTokenConfiguration;
import com.mangkyu.devnews.app.accesstoken.issue.domain.AccessToken;
import com.mangkyu.devnews.app.accesstoken.issue.domain.IssueAccessTokenUseCase;
import com.mangkyu.devnews.app.bot.BotConfiguration;
import com.mangkyu.devnews.app.bot.sendmessage.infra.SendBotMessageFeignClient;
import com.mangkyu.devnews.config.feign.EnableFeignTest;
import com.mangkyu.devnews.config.properties.PropertiesConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@EnableFeignTest
@SpringBootTest(classes = {BotConfiguration.class, AccessTokenConfiguration.class, PropertiesConfig.class})
class SendBotMessageUseCaseTest {

    @Autowired
    private SendBotMessageUseCase useCase;


    @Autowired
    private IssueAccessTokenUseCase accessTokenUseCase;

    @Autowired
    private SendBotMessageFeignClient client;

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