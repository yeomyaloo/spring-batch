package com.example.springbatchscheduler.member.dto;


import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MemberIdResponseDto {

    private Long memberId;

}
