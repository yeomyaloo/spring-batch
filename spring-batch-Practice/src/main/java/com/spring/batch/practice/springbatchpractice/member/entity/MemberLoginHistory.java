package com.spring.batch.practice.springbatchpractice.member.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "member_login_history")
public class MemberLoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Member member;

    private LocalDateTime memberLoginTime;

}
