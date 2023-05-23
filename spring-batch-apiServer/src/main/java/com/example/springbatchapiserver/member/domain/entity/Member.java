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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;


    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name = "is_sleeper_account", nullable = false)
    private boolean isSleeperAccount;

    @Column(name = "birthday", nullable = false)
    private String birthday;


    public void switchedSleeperAccount(){
        if (this.isSleeperAccount){
            //TODO:  해당하는 에러를 명확하게 명시
            throw new RuntimeException();
        }
        this.isSleeperAccount = true;
    }

}
