package com.mangkyu.devnews.app.member.add.domain;

import com.mangkyu.devnews.app.member.Member;

public interface AddMemberClient {
    Member save(Member member);
}
