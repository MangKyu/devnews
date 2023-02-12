package com.mangkyu.devnews.app.member;

public class TestMemberData {

    public static Member member() {
        return Member.builder()
                .userId("c72af563-0f21-4736-11e4-045237113344")
                .domainId(101)
                .channelId("12345a12-b12c-12d3-e123fghijkl")
                .secretKey("secretKey")
                .build();
    }


}
