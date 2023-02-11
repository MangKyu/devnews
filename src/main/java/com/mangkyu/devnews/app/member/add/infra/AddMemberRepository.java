package com.mangkyu.devnews.app.member.add.infra;

import com.mangkyu.devnews.app.member.Member;
import com.mangkyu.devnews.app.member.add.domain.AddMemberClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddMemberRepository extends JpaRepository<Member, Long>, AddMemberClient {
}
