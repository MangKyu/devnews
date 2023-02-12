package com.mangkyu.devnews.app.message.question.infra;

import com.mangkyu.devnews.app.message.question.domain.GetQuestionAnswerClient;
import com.mangkyu.devnews.system.bean.RealService;
import lombok.RequiredArgsConstructor;

@RealService
@RequiredArgsConstructor
public class GetQuestionAnswerChatGptAdapter implements GetQuestionAnswerClient {

    private final GetChatGptFeignClient getChatGptFeignClient;

    @Override
    public String getAnswer(String question, String secretKey) {
        return null;
//        return getChatGptFeignClient.getAnswer(question);
    }
}
