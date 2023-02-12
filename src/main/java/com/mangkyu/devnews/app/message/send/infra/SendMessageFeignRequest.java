package com.mangkyu.devnews.app.message.send.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SendMessageFeignRequest {

    private Content content;

    public SendMessageFeignRequest(String message) {
        this.content = new Content("text", message);
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Content {
        private String type;
        private String text;
    }

}
