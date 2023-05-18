package com.example.springbatchapiserver.member.domain.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;


    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;


    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    private String birthday;




}
