package com.example.tpboard.repository;

import com.example.tpboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoy extends JpaRepository<Member, Long> {
}
