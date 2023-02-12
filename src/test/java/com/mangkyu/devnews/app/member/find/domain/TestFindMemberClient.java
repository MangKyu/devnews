package com.mangkyu.devnews.app.member.find.domain;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.system.bean.TestService;

import java.util.Optional;

@TestService
class TestFindMemberClient implements FindMemberClient {

    @Override
    public Optional<Member> findByUserId(String userId) {
        return Optional.of(Member.builder().userId(userId).secretKey("secretKey").build());
    }
}