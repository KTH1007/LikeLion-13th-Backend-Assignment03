package com.likelion.springcrud.member.domain.repository;

import com.likelion.springcrud.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
