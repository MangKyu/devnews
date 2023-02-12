package com.mangkyu.devnews.app.message.question.infra;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "GetChatGptFeignClient")
public interface GetChatGptFeignClient {
}
