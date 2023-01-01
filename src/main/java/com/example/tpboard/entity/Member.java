package com.example.tpboard.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;
    private String password;
    private String email;

    @Builder
    public Member(Long id, String accountId, String password, String email) {
        this.id = id;
        this.accountId = accountId;
        this.password = password;
        this.email = email;
    }
}
