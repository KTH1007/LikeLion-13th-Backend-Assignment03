package com.likelion.springcrud.member.api.dto.request;

public record MemberSaveRequestDto(
        String name,
        int age
) {
}
