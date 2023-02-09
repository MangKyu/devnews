package com.mangkyu.devnews.app.member.find.domain;

import com.mangkyu.devnews.app.member.Member;

import java.util.Optional;

public interface FindMemberClient {
    Optional<Member> findByUserId(String userId);
}
