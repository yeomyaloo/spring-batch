package com.example.springbatchapiserver.member.service;

import com.example.springbatchapiserver.member.domain.dto.BirthdayMemberResponse;
import com.example.springbatchapiserver.member.domain.dto.MemberRequestDto;
import com.example.springbatchapiserver.member.domain.dto.MemberResponseDto;
import com.example.springbatchapiserver.member.domain.entity.Member;
import com.example.springbatchapiserver.member.persistence.querydsl.QuerydslMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class QueryMemberServiceImpl implements QueryMemberService{

    private final QuerydslMemberRepository querydslMemberRepository;


    @Override
    public List<BirthdayMemberResponse> findBirthdayMemberByLaterDay(String laterDay) {

        List<Member> members = Objects.requireNonNull(querydslMemberRepository.findBirthdayMemberByLaterDay(laterDay));

        return members
                .stream()
                .map(member -> BirthdayMemberResponse.fromEntity(member)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<MemberResponseDto> findSleeperAccountMember(MemberRequestDto responseDto) {

        List<Member> members = Objects.requireNonNull(querydslMemberRepository.findMembersById(responseDto.getMemberId()));

        members.forEach(Member::switchedSleeperAccount);

        return members.stream().map(MemberResponseDto::fromEntity).collect(Collectors.toList());
    }


}
