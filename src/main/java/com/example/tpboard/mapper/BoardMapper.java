package com.example.tpboard.mapper;

import com.example.tpboard.dto.request.BoardRequest;
import com.example.tpboard.dto.response.BoardResponse;
import com.example.tpboard.entity.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {

    public Board mapToEntity(BoardRequest dto) {
        return Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(dto.getMember())
                .build();
    }

    public BoardResponse mapToDto(Board entity) {
        return BoardResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .member(entity.getMember())
                .build();
    }
}
