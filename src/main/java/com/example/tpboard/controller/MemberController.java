package com.example.tpboard.controller;

import com.example.tpboard.dto.TokenInfo;
import com.example.tpboard.dto.request.MemberLoginRequestDto;
import com.example.tpboard.dto.request.MemberRequest;
import com.example.tpboard.dto.response.MemberResponse;
import com.example.tpboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/account")
    public ResponseEntity<Void> create(@RequestBody MemberRequest dto) {
        memberService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto dto) {
        return memberService.login(dto);
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
