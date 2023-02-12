package com.mangkyu.devnews.app.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userId;
    private int domainId;
    private String channelId;
    private String secretKey;


    public void update(String channelId, String secretKey) {
        this.channelId = channelId;
        this.secretKey = secretKey;
    }
}
