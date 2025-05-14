package com.likelion.springcrud.review.application;

import com.likelion.springcrud.member.domain.Member;
import com.likelion.springcrud.member.domain.repository.MemberRepository;
import com.likelion.springcrud.review.api.dto.request.ReviewSaveRequestDto;
import com.likelion.springcrud.review.api.dto.response.ReviewInfoResponseDto;
import com.likelion.springcrud.review.api.dto.response.ReviewListResponseDto;
import com.likelion.springcrud.review.domain.Review;
import com.likelion.springcrud.review.domain.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void saveReview(ReviewSaveRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.memberId()).orElseThrow(IllegalArgumentException::new);
        Review review = Review.builder()
                .rating(requestDto.rating())
                .content(requestDto.content())
                .member(member)
                .build();

        reviewRepository.save(review);
    }


    public ReviewListResponseDto reviewFindMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        List<ReviewInfoResponseDto> reviews = reviewRepository.findByMember(member).stream()
                .map(ReviewInfoResponseDto::from)
                .toList();

        return ReviewListResponseDto.from(reviews);
    }
}
