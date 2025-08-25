package com.example.rebound.controller;

import com.example.rebound.dto.LikeDTO;
import com.example.rebound.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<?> like(@RequestBody LikeDTO likeDTO) {
        likeService.like(likeDTO);
        return ResponseEntity.ok(likeDTO);
    }
}
