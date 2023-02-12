package com.mangkyu.devnews.app.member.add.infra;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.add.domain.AddMemberClient;
import com.mangkyu.devnews.system.bean.TestService;

@TestService
class TestAddMemberClient implements AddMemberClient {

    @Override
    public Member save(Member member) {
        return null;
    }
}