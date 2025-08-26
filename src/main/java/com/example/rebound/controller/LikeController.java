package com.example.rebound.controller;

import com.example.rebound.dto.LikeDTO;
import com.example.rebound.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/likes/**")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

//    댓글 추천
    @PostMapping
    public ResponseEntity<?> like(@RequestBody LikeDTO likeDTO) {
        likeService.like(likeDTO);
        return ResponseEntity.ok(likeDTO);
    }

//    추천 취소
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> removeLike(@PathVariable Long commentId, @RequestParam Long memberId) {
        likeService.removeLike(commentId, memberId);
        return ResponseEntity.ok().build();
    }

    // 추천 갯수 조회
    @GetMapping("/{commentId}/count")
    public ResponseEntity<?> getLikeCount(@PathVariable Long commentId) {
        return ResponseEntity.ok(likeService.getLikeCount(commentId));
    }

    // 추천 여부 확인
    @GetMapping("/{commentId}/check/{memberId}")
    public ResponseEntity<?> checkLike(@PathVariable Long commentId, @PathVariable Long memberId) {
        return ResponseEntity.ok(likeService.checkedLike(commentId, memberId));
    }
}
