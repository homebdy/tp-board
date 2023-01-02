package com.example.tpboard.dto.request;

import lombok.Getter;

@Getter
public class MemberLoginRequestDto {

    private String accountId;
    private String password;
}
