package com.mangkyu.devnews.app.member.add.domain;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.find.domain.FindMemberUseCase;
import com.mangkyu.devnews.app.message.receive.ReceiveMessage;
import com.mangkyu.devnews.app.message.receive.SaveSecretKeyEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class AddMemberUseCase {

    private final FindMemberUseCase findMemberUseCase;
    private final AddMemberClient addMemberClient;

    @EventListener
    @Transactional
    public void save(SaveSecretKeyEvent event) {
        ReceiveMessage message = event.getMessage();
        Member member = add(message.getUserId(), message.getDomainId(), message.getChannelId(), event.getSecretKey());

        member.update(message.getChannelId(), message.getMessage());
    }

    @Transactional
    Member add(String userId, int domainId, String channelId, String secretKey) {
        return findMemberUseCase.find(userId)
                .orElseGet(() -> save(userId, domainId, channelId, secretKey));

    }

    private Member save(String userId, int domainId, String channelId, String secretKey) {
        Member member = Member.builder()
                .domainId(domainId)
                .userId(userId)
                .channelId(channelId)
                .secretKey(secretKey)
                .build();
        return addMemberClient.save(member);
    }
}
