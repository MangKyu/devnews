package com.mangkyu.devnews.app.member.find.infra;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.find.domain.FindMemberClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FindMemberRepository extends JpaRepository<Member, Long>, FindMemberClient {

    Optional<Member> findByUserId(String userId);

}
