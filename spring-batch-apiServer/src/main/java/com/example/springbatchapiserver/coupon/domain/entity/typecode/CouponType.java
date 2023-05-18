package com.example.springbatchapiserver.coupon.domain.entity.typecode;


import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CouponType {

    FIXED_PRICE(1, "정액쿠폰"), FIXED_RATE(2,"정률쿠폰");

    private final int code;
    private final String codeName;


}
