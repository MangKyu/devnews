package com.mangkyu.devnews.app.message.question.domain;

public interface GetQuestionAnswerClient {
    String getAnswer(String question, String secretKey);
}
