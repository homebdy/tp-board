package com.example.tpboard.service;

import com.example.tpboard.dto.request.BoardRequest;
import com.example.tpboard.dto.response.BoardResponse;
import com.example.tpboard.entity.Board;
import com.example.tpboard.mapper.BoardMapper;
import com.example.tpboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServcie {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public void create(BoardRequest request) {
        Board board = boardMapper.mapToEntity(request);
        boardRepository.save(board);
    }

    public BoardResponse getById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return boardMapper.mapToDto(board);
    }

    public List<BoardResponse> getAll() {
        return boardRepository.findAll()
                .stream()
                .map(boardMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
