package com.example.springbatchapiserver.member.persistence.querydsl;

import com.example.springbatchapiserver.member.domain.entity.Member;

import java.text.ParseException;
import java.util.List;

public interface QuerydslMemberRepository {

    Member findMemberById(Long id);

    Member findMemberByLoginId(String loginId);

    List<Member> findBirthdayMemberByLaterDay(String laterDay);

    List<Member> findMembersById(Long id);



}
