package com.mangkyu.devnews.app.message.receive.domain;

import com.mangkyu.devnews.app.message.receive.ReceiveMessage;
import com.mangkyu.devnews.app.message.receive.ReceiveMessageEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveMessageUseCase {

    private final ApplicationEventPublisher eventPublisher;

    public void handle(ReceiveMessage message) {
        ReceiveMessageEvent event = message.toEvent();
        eventPublisher.publishEvent(event);
    }

}
