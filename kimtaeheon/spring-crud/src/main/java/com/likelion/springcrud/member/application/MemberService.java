package com.likelion.springcrud.member.application;

import com.likelion.springcrud.member.api.dto.request.MemberSaveRequestDto;
import com.likelion.springcrud.member.api.dto.response.MemberInfoResponseDto;
import com.likelion.springcrud.member.api.dto.response.MemberListResponseDto;
import com.likelion.springcrud.member.domain.Member;
import com.likelion.springcrud.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void memberSave(MemberSaveRequestDto requestDto) {
        Member member = Member.builder()
                .name(requestDto.name())
                .age(requestDto.age())
                .build();
        memberRepository.save(member);
    }

    public MemberInfoResponseDto memberFindOne(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return MemberInfoResponseDto.from(member);
    }

    public MemberListResponseDto memberFindAll() {
        List<MemberInfoResponseDto> members = memberRepository.findAll().stream().map(MemberInfoResponseDto::from).toList();
        return MemberListResponseDto.from(members);
    }
}
