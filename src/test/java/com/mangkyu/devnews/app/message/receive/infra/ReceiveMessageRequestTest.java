package com.mangkyu.devnews.app.message.receive.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mangkyu.devnews.app.message.receive.ReceiveMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureJson
@ExtendWith(SpringExtension.class)
class ReceiveMessageRequestTest {

    @Autowired
    private ObjectMapper mapper;

    @Test
    void json변환테스트() throws JsonProcessingException {
        // given

        // when
        ReceiveMessageRequest result = mapper.readValue(jsonMessage(), ReceiveMessageRequest.class);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void domain객체로변환테스트() throws JsonProcessingException {
        // given
        ReceiveMessageRequest request = mapper.readValue(jsonMessage(), ReceiveMessageRequest.class);

        // when
        ReceiveMessage result = request.toDomain();

        // then
        assertThat(result).isNotNull();
        assertThat(result.getUserId()).isEqualTo(request.getSource().getUserId());
        assertThat(result.getDomainId()).isEqualTo(request.getSource().getDomainId());
        assertThat(result.getChannelId()).isEqualTo(request.getSource().getChannelId());
        assertThat(result.getMessage()).isEqualTo(request.getContent().getText());
    }

    private String jsonMessage() {
        return "{ \"type\": \"message\", \"source\": { \"userId\": \"c72af563-0f21-4736-11e4-045237113344\", \"channelId\": \"12345a12-b12c-12d3-e123fghijkl\", \"domainId\": 40029600 }, \"issuedTime\": \"2022-01-04T05:16:05.716Z\", \"content\": { \"type\": \"text\", \"text\": \"hello\" } }";
    }

}