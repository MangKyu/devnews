package com.mangkyu.devnews.app.message.receive.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveMessageSource {
    @NotNull
    private String userId;
    private String channelId;
    private int domainId;

}
