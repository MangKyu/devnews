package com.mangkyu.devnews.app.bot.receivemessage.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mangkyu.devnews.app.accesstoken.AccessTokenConfiguration;
import com.mangkyu.devnews.app.bot.BotConfiguration;
import com.mangkyu.devnews.config.properties.PropertiesConfig;
import com.mangkyu.system.TestActiveProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestActiveProfile
@AutoConfigureJson
@AutoConfigureWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = {BotConfiguration.class, AccessTokenConfiguration.class, PropertiesConfig.class})
class ReceiveMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void 메세지수신() throws Exception {
        // given
        ReceiveMessageRequest request = receiveMessageRequest();

        // when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/callback")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        );

        // then


        resultActions.andExpect(status().isOk());
    }

    private ReceiveMessageRequest receiveMessageRequest() {
        return ReceiveMessageRequest.builder()
                .type("message")
                .source(source())
                .issuedTime(LocalDateTime.now())
                .content(content())
                .build();
    }

    private ReceiveMessageContent content() {
        return ReceiveMessageContent.builder()
                .type("text")
                .text("hello")
                .build();
    }

    private ReceiveMessageSource source() {
        return ReceiveMessageSource.builder()
                .userId("c72af563-0f21-4736-11e4-045237113344")
                .channelId("12345a12-b12c-12d3-e123fghijkl")
                .domainId(40029600)
                .build();
    }


}