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
public class QueryMemberServiceImpl implements QueryMemberService {

    private final QuerydslMemberRepository querydslMemberRepository;


    @Override
    public List<BirthdayMemberResponse> findBirthdayMemberByLaterDay(String laterDay) {

        List<Member> members = Objects.requireNonNull(querydslMemberRepository.findBirthdayMemberByLaterDay(laterDay));

        return members
                .stream()
                .map(member -> BirthdayMemberResponse.fromEntity(member)).collect(Collectors.toList());
    }



    public List<MemberResponseDto> findSleeperMembers(List<MemberRequestDto> request) {
        List<MemberResponseDto> responseDtoList = new ArrayList<>();

        for (MemberRequestDto dto : request) {
            Member member = Objects.requireNonNull(querydslMemberRepository.findMemberById(dto.getMemberId()));

            MemberResponseDto memberResponseDto = MemberResponseDto.fromEntity(member);

            responseDtoList.add(memberResponseDto);
        }
        return Objects.requireNonNull(responseDtoList);
    }
}