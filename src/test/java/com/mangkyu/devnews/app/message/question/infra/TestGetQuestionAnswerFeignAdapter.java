package com.mangkyu.devnews.app.message.question.infra;

import com.mangkyu.devnews.app.message.question.domain.GetQuestionAnswerClient;
import com.mangkyu.devnews.system.bean.TestService;
import org.apache.commons.lang3.StringUtils;

@TestService
class TestGetQuestionAnswerFeignAdapter implements GetQuestionAnswerClient {

    @Override
    public String getAnswer(String question, String secretKey) {
        return StringUtils.EMPTY;
    }
}