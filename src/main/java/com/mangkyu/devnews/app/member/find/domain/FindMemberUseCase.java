package com.mangkyu.devnews.app.member.find.domain;

import com.mangkyu.devnews.app.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class FindMemberUseCase {

    private final FindMemberClient client;

    Optional<Member> find(String userId) {
        return client.findByUserId(userId);
    }
}
