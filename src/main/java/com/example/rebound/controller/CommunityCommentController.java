package com.example.rebound.controller;

import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.dto.CommentCriteriaDTO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.CommentService;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<?> write(@RequestBody CommentDTO commentDTO, HttpSession session) {
        MemberDTO member = (MemberDTO) session.getAttribute("member");
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("로그인이 필요합니다.");
        }
        commentDTO.setMemberId(member.getId());
        commentDTO.setMemberName(member.getMemberName());
        commentService.write(commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

//    전체 조회
    @GetMapping("/{page}")
    public ResponseEntity<?> list(@PathVariable int page, @RequestParam Long postId){
        CommentCriteriaDTO commentCriteriaDTO = commentService.getComments(postId, page);
        if(commentCriteriaDTO.getComments().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(commentCriteriaDTO);
        }
        return ResponseEntity.ok().body(commentCriteriaDTO);
    }

//    수정
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CommentDTO commentDTO) {
        commentService.update(commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

//    삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.ok(id + "번 댓글 삭제");
    }
}
