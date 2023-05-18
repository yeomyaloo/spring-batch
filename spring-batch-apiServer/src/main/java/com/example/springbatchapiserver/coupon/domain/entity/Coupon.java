package com.example.springbatchapiserver.coupon.domain.entity;


import com.example.springbatchapiserver.coupon.common.converter.CouponTypeConverter;
import com.example.springbatchapiserver.coupon.domain.entity.typecode.CouponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coupons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "coupon_type")
    @Convert(converter = CouponTypeConverter.class)
    private CouponType couponType;

    @Column(name = "expiry_date")
    private Boolean expiryDate;

}
