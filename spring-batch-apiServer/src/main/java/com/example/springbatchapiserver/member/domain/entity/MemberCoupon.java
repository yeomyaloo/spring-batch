package com.example.springbatchapiserver.member.domain.entity;

import com.example.springbatchapiserver.coupon.domain.entity.Coupon;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "member_coupon")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class MemberCoupon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "coupon_code", nullable = false, unique = true)
    private String couponCode;

    @Column(nullable = false)
    private boolean isUsed;


    @Column(nullable = false)
    private LocalDate expiryDate;




    public void use(){

        if(this.isUsed){
            throw new RuntimeException();
        }

        this.isUsed = true;
    }
}
