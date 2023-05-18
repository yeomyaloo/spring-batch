package com.example.springbatchapiserver.coupon.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


/**
 * 정률 할인 쿠폰 엔티티 입니다.
 * */
@Getter
@NoArgsConstructor
@Table(name = "fixed_rate_discount_coupon")
@Entity
@PrimaryKeyJoinColumn(name = "id")
@SuperBuilder
public class FixedRateDiscountCoupon extends Coupon{


    @Column(nullable = false)
    private int minimumAmount;

    @Column(nullable = false)
    private int discountAmount;
}
