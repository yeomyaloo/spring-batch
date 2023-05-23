package com.example.springbatchapiserver.member.service;

import com.example.springbatchapiserver.member.domain.dto.BirthdayMemberResponse;
import com.example.springbatchapiserver.member.domain.dto.MemberRequestDto;
import com.example.springbatchapiserver.member.domain.dto.MemberResponseDto;

import java.util.List;

public interface QueryMemberService {

    List<BirthdayMemberResponse> findBirthdayMemberByLaterDay(String laterDay);

    List<MemberResponseDto> findSleeperMembers(List<MemberRequestDto> request);

}
