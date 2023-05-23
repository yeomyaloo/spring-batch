package com.example.springbatchapiserver.member.persistence.inter;

import com.example.springbatchapiserver.member.domain.entity.Member;

public interface CommonMemberRepository {

    Member save(Member member);
}
