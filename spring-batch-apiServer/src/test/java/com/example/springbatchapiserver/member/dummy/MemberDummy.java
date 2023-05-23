package com.example.springbatchapiserver.member.dummy;

import com.example.springbatchapiserver.member.domain.entity.Member;

public class MemberDummy {

    public static Member dummy(){

        return Member.builder()
                .loginId("test")
                .password("1234")
                .name("test name")
                .isDeleted(false)
                .isSleeperAccount(false)
                .birthday("19960320")
                .build();
    }
}
