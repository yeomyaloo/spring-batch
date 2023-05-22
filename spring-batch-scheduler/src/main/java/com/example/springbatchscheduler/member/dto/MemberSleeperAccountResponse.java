package com.example.springbatchscheduler.member.dto;


import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberSleeperAccountResponse {

    private Long memberId;
    private boolean isSleeperAccount;
}
