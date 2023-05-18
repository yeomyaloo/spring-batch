package com.example.springbatchapiserver.member.service;

import com.example.springbatchapiserver.member.domain.dto.BirthdayMemberResponse;

import java.util.List;

public interface QueryMemberService {

    List<BirthdayMemberResponse> getBirthdayMemberByLaterDay(String laterDay);



}
