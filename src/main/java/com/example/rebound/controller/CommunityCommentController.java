package com.example.rebound.controller;

import com.example.rebound.dto.CommentDTO;
import com.example.rebound.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/comments/**")
@RequiredArgsConstructor
public class CommunityCommentController {
    private final CommentService commentService;
//    추가
    @PostMapping("/write")
    public ResponseEntity<?> write(@RequestBody CommentDTO commentDTO) {
        commentService.write(commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

//    전체 조회
    @GetMapping("/list")
    public ResponseEntity<?> list(Long postId) {
        List<CommentDTO> comments = commentService.getComments(postId);
        if(comments.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(comments);
        }
        return ResponseEntity.ok().body(comments);
    }
}
