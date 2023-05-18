package com.example.springbatchapiserver.coupon.common.converter;


import com.example.springbatchapiserver.coupon.domain.entity.typecode.CouponType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter
public class CouponTypeConverter implements AttributeConverter<CouponType, Integer> {


    /**
     * 해당 쿠폰의 코드를 Integer 형태로 변환해서 반환해줍니다.
     *
     * @param couponType 쿠폰 코드
     * @return 쿠폰 코드
     * */

    @Override
    public Integer convertToDatabaseColumn(CouponType couponType) {
        return couponType.getCode();
    }


    /**
     * 해당 쿠폰의 코드를 Integer 값으로 받아 couponType으로 변환해서 반환해줍니다.
     *
     * @param integer 쿠폰 코드 id값
     * @return 쿠폰 타입
     * */
    @Override
    public CouponType convertToEntityAttribute(Integer integer) {
        return Arrays.stream(CouponType.values())
                .filter(couponCode -> integer.equals(couponCode.getCode()))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
