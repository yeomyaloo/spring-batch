package com.example.springbatchscheduler.member.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberSleeperAccountRequest {

    private Long memberId;
    private boolean isSleeperAccount;

    public MemberSleeperAccountRequest(Long memberId) {
        this.memberId = memberId;
    }
}
