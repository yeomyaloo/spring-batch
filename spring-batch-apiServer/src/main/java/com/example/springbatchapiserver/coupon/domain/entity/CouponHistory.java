package com.example.springbatchapiserver.coupon.domain.entity;

import com.example.springbatchapiserver.coupon.common.converter.CouponStateCodeConverter;
import com.example.springbatchapiserver.coupon.domain.entity.typecode.CouponUsedStateCode;
import jakarta.persistence.*;

import java.time.LocalDate;

public class CouponHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String couponCode;


    @Column(nullable = false)
    private LocalDate issuanceTime;

    @Column(nullable = false)
    private LocalDate expiryTime;


    @Column(name = "used_time")
    private LocalDate usedTime;

    @Column(name = "coupon_state_code")
    @Convert(converter = CouponStateCodeConverter.class)
    private CouponUsedStateCode couponUsedStateCode;



}
