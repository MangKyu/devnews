package com.mangkyu.devnews.app.member.add.domain;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.find.domain.FindMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class AddMemberUseCase {

    private final FindMemberUseCase findMemberUseCase;
    private final AddMemberClient addMemberClient;

    @Transactional
    public void add(String userId, int domainId, String channelId, String secretKey) {
        findMemberUseCase.find(userId)
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
