package com.example.springbatchapiserver.member.service;

import com.example.springbatchapiserver.member.domain.dto.MemberRequestDto;
import com.example.springbatchapiserver.member.domain.dto.MemberResponseDto;
import com.example.springbatchapiserver.member.domain.entity.Member;
import com.example.springbatchapiserver.member.dummy.MemberDummy;
import com.example.springbatchapiserver.member.persistence.querydsl.QuerydslMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QueryMemberServiceImplTest {


    private QuerydslMemberRepository querydslMemberRepository;
    private QueryMemberServiceImpl queryMemberService;


    @BeforeEach
    void setup(){
        querydslMemberRepository = Mockito.mock(QuerydslMemberRepository.class);

        queryMemberService = new QueryMemberServiceImpl(querydslMemberRepository);

    }

    @DisplayName("넘겨받은 request dto로 해당 회원들을 휴먼 회원으로 만드는 서비스 로직 테스트")
    @Test
    void findSleeperMembers() {
        //given
        Long memberId= 0L;
        Member member = Mockito.mock(Member.class);
        MemberRequestDto memberRequestDto = Mockito.mock(MemberRequestDto.class);

        List<MemberRequestDto> requestDtos = Mockito.mock(List.class);

        Mockito.when(querydslMemberRepository.findMemberById(memberId)).thenReturn(member);

        //when
        queryMemberService.findSleeperMembers(requestDtos);

        verify(querydslMemberRepository, times(1)).findMemberById(memberId);
    }


}