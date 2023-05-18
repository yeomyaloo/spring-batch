package com.example.springbatchapiserver.member.domain.dto;


import com.example.springbatchapiserver.member.domain.entity.Member;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BirthdayMemberResponse {

    private Long memberId;


    public static BirthdayMemberResponse fromEntity(Member member){
        return new BirthdayMemberResponse(member.getMemberId());

    }
}
