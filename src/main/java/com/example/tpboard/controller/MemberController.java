package com.example.tpboard.controller;

import com.example.tpboard.dto.request.BoardRequest;
import com.example.tpboard.dto.request.MemberRequest;
import com.example.tpboard.dto.response.BoardResponse;
import com.example.tpboard.dto.response.MemberResponse;
import com.example.tpboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberController {

    private final MemberService memberService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MemberRequest dto) {
        memberService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAll() {
        return ResponseEntity.ok(memberService.getAll());
    }
}
