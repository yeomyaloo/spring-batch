package com.spring.batch.practice.springbatchpractice.member.common;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberState {

    ACTIVE(1),
    SLEEPER(2);

    private final int memberState;


}
