package com.spring.batch.practice.springbatchpractice.member.entity;


import com.spring.batch.practice.springbatchpractice.member.common.MemberState;
import com.spring.batch.practice.springbatchpractice.member.common.MemberStateConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    private String password;


    @Column(name = "member_state", nullable = false)
    @Convert(converter = MemberStateConverter.class)
    private MemberState memberState;

}
