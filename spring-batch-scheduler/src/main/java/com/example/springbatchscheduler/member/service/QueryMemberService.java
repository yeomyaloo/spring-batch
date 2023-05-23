package com.example.springbatchscheduler.member.service;

import com.example.springbatchscheduler.member.dto.MemberIdResponseDto;
import com.example.springbatchscheduler.member.dto.MemberRequestDto;

import java.util.List;

public interface QueryMemberService {

    List<MemberIdResponseDto> findBirthdayMemberByLaterDay(String laterDay);

    List<MemberIdResponseDto> findSleeperAccountMembers(MemberRequestDto requestDto);
}
