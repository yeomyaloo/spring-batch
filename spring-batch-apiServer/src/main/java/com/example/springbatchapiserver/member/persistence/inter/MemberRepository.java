package com.example.springbatchapiserver.member.persistence.inter;


import com.example.springbatchapiserver.member.domain.entity.Member;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long>, CommonMemberRepository {

}
