package com.example.tpboard.controller;

import com.example.tpboard.dto.request.BoardRequest;
import com.example.tpboard.dto.response.BoardResponse;
import com.example.tpboard.service.BoardServcie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardController {

    private final BoardServcie boardServcie;
    private final Logger log = LoggerFactory.getLogger(getClass());
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody BoardRequest dto) {
        boardServcie.create(dto);
        log.debug(dto.toString());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<BoardResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(boardServcie.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BoardResponse>> getAll() {
        return ResponseEntity.ok(boardServcie.getAll());
    }
}
