package com.example.springbatchapiserver.coupon.domain.entity.typecode;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CouponUsedStateCode {

    UN_USED(1,"미사용"), HOLDING(2, "사용중") ,USED(3,"사용 완료");

    private final int code;
    private final String codeName;

}
