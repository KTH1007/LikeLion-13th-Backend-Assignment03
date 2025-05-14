package com.likelion.springcrud.review.api.dto.request;

public record ReviewSaveRequestDto(
        Long memberId,
        int rating,
        String content
) {
}
