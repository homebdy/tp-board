package com.example.tpboard.dto.request;

import com.example.tpboard.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    private String title;
    private String content;
    private Member member;
}
