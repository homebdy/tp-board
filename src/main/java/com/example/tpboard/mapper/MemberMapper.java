package com.example.tpboard.mapper;

import com.example.tpboard.dto.request.BoardRequest;
import com.example.tpboard.dto.request.MemberRequest;
import com.example.tpboard.dto.response.MemberResponse;
import com.example.tpboard.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member mapToEntity(MemberRequest dto) {
        return Member.builder()
                .accountId(dto.getAccountId())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
    }

    public MemberResponse mapToDto(Member entity) {
        return MemberResponse.builder()
                .id(entity.getId())
                .accountId(entity.getAccountId())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .build();
    }
}
