package com.example.springbatchapiserver.coupon.common.converter;


import com.example.springbatchapiserver.coupon.domain.entity.typecode.CouponUsedStateCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CouponStateCodeConverter implements AttributeConverter<CouponUsedStateCode, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CouponUsedStateCode couponUsedStateCode) {
        return null;
    }

    @Override
    public CouponUsedStateCode convertToEntityAttribute(Integer integer) {
        return null;
    }
}
