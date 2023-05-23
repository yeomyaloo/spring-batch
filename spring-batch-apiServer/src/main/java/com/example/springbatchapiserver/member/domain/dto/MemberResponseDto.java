package com.example.springbatchapiserver.member.domain.dto;


import com.example.springbatchapiserver.member.domain.entity.Member;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MemberResponseDto {

    private Long memberId;

    public static MemberResponseDto fromEntity(Member member){
        return MemberResponseDto.builder()
                .memberId(member.getMemberId())
                .build();
    }

}
