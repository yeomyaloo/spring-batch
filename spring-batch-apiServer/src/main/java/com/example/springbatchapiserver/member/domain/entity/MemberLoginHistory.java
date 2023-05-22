package com.example.springbatchapiserver.member.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "member_login_history")
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class MemberLoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @Column(name = "login_time", nullable = false)
    private LocalDate loginTime;


}
