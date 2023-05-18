package com.example.springbatchapiserver.member.persistence.querydsl;


import com.example.springbatchapiserver.member.domain.entity.Member;
import com.example.springbatchapiserver.member.domain.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



@RequiredArgsConstructor
@Repository
public class QuerydslMemberRepositoryImpl implements QuerydslMemberRepository{


    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Member findMemberById(Long id) {

        QMember member = QMember.member;

        return jpaQueryFactory.
                selectFrom(member).
                where(member.memberId.eq(id)).
                fetchOne();

    }

    @Override
    public Member findMemberByLoginId(String loginId) {
        QMember member = QMember.member;

        return jpaQueryFactory.
                selectFrom(member).
                where(member.loginId.eq(loginId)).
                fetchOne();
    }

    @Override
    public List<Member> findBirthdayMemberByLaterDay(String laterDay) {
        QMember member = QMember.member;


        LocalDate localDate = LocalDate.now().plusDays(Long.parseLong(laterDay));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd");
        String later = localDate.format(formatter);

        return jpaQueryFactory.
                selectFrom(member).
                where(member.birthday.substring(4).eq(later.toString()),
                        member.isDeleted.isFalse())
                .fetch();
    }
}
