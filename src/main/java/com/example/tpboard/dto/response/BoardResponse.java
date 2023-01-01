package com.example.tpboard.dto.response;

import com.example.tpboard.entity.Member;
import lombok.Builder;

@Builder
public class BoardResponse {

    private Long id;
    private String title;
    private String content;
    private Member member;
}
