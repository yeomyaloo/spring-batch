package com.example.springbatchapiserver.member.persistence.inter;

import com.example.springbatchapiserver.member.domain.entity.Member;
import com.example.springbatchapiserver.member.dummy.MemberDummy;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {


    private Member member;

    @Autowired
    TestEntityManager entityManager;


    @Autowired
    MemberRepository memberRepository;


    @BeforeEach
    void setUp() {
        member = MemberDummy.dummy();
        Member persist = entityManager.persist(member);

    }


    @DisplayName("회원 저장 테스트")
    @Test
    void testSave(){
        //given
        Long memberId = member.getMemberId();

        //when
        Member save = memberRepository.save(member);

        //then
        assertThat(save.getMemberId()).isEqualTo(memberId);

    }


}