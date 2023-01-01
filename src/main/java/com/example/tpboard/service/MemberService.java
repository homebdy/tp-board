package com.example.tpboard.service;

import com.example.tpboard.dto.request.MemberRequest;
import com.example.tpboard.dto.response.BoardResponse;
import com.example.tpboard.dto.response.MemberResponse;
import com.example.tpboard.entity.Board;
import com.example.tpboard.entity.Member;
import com.example.tpboard.mapper.MemberMapper;
import com.example.tpboard.repository.MemberRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepositoy memberRepository;
    private final MemberMapper memberMapper;

    public void create(MemberRequest request) {
        Member member = memberMapper.mapToEntity(request);
        System.out.println(member.getAccountId());
        memberRepository.save(member);
    }

    public MemberResponse getById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return memberMapper.mapToDto(member);
    }

    public List<MemberResponse> getAll() {
        return memberRepository.findAll()
                .stream()
                .map(memberMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
