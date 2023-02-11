package com.mangkyu.devnews.app.bot.receivemessage.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveMessageContent {

    @NotNull
    private String type;

    @NotNull
    private String text;

}
