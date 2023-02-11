package com.mangkyu.devnews.app.bot.receivemessage.infra;

import com.mangkyu.devnews.app.bot.receivemessage.ReceiveMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveMessageRequest {

    @NotNull
    private String type;
    @NotNull
    private ReceiveMessageSource source;
    @NotNull
    private ReceiveMessageContent content;
    @NotNull
    private LocalDateTime issuedTime;


    public ReceiveMessage toDomain() {
        return ReceiveMessage.builder()
                .userId(source.getUserId())
                .domainId(source.getDomainId())
                .channelId(source.getChannelId())
                .message(content.getText())
                .build();
    }
}
