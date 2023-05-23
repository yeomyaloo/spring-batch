package com.example.springbatchapiserver.member.domain.dto;


import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MemberRequestDto {
    private Long memberId;
}
