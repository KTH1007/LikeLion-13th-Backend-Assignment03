package com.likelion.springcrud.review.api;

import com.likelion.springcrud.review.api.dto.request.ReviewSaveRequestDto;
import com.likelion.springcrud.review.api.dto.response.ReviewListResponseDto;
import com.likelion.springcrud.review.application.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/save")
    public ResponseEntity<String> postSave(@RequestBody ReviewSaveRequestDto requestDto) {
        reviewService.saveReview(requestDto);
        return new ResponseEntity<>("리뷰 작성", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewListResponseDto> myPostFindAll(@PathVariable("id") Long id) {
        ReviewListResponseDto reviewListResponseDto = reviewService.reviewFindMember(id);
        return new ResponseEntity<>(reviewListResponseDto, HttpStatus.OK);
    }
}
