package com.likelion.springcrud.member.api;

import com.likelion.springcrud.member.api.dto.request.MemberSaveRequestDto;
import com.likelion.springcrud.member.api.dto.response.MemberInfoResponseDto;
import com.likelion.springcrud.member.api.dto.response.MemberListResponseDto;
import com.likelion.springcrud.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public ResponseEntity<String> memberSave(@RequestBody MemberSaveRequestDto requestDto) {
        memberService.memberSave(requestDto);
        return new ResponseEntity<>("사용자 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<MemberListResponseDto> memberFindAll() {
        MemberListResponseDto memberListResponseDto = memberService.memberFindAll();
        return new ResponseEntity<>(memberListResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberInfoResponseDto> memberFindOne(@PathVariable("id") Long id) {
        MemberInfoResponseDto memberInfoResponseDto = memberService.memberFindOne(id);
        return new ResponseEntity<>(memberInfoResponseDto, HttpStatus.OK);
    }
}
