package com.spring.batch.practice.springbatchpractice.member.common;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class MemberStateConverter implements AttributeConverter<MemberState, Integer> {


    @Override
    public Integer convertToDatabaseColumn(MemberState memberState) {
        return memberState.getMemberState();
    }

    @Override
    public MemberState convertToEntityAttribute(Integer memberState) {

        if(Objects.isNull(memberState)){
            return null;
        }
        return Stream.of(MemberState.values())
                .filter(m -> memberState.equals(m.getMemberState())).findFirst()
                .orElseThrow(IllegalAccessError::new);

    }

}
