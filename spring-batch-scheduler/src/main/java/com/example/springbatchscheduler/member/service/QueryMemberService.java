package com.example.springbatchscheduler.member.service;

import com.example.springbatchscheduler.member.dto.BirthdayMemberResponse;

import java.util.List;

public interface QueryMemberService {

    List<BirthdayMemberResponse> findBirthdayMemberByLaterDay(String laterDay);

}
