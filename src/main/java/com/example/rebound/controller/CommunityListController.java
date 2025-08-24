package com.example.rebound.controller;

import com.example.rebound.common.exception.PostNotFoundException;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.service.CommunityListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/community-list/**")
@RequiredArgsConstructor
public class CommunityListController {
    private final CommunityListService communityPostService;

    //    게시글 목록
    @GetMapping("community-posts")
    public String showPosts(Model model) {
        model.addAttribute("posts", communityPostService.findPostsCriteria(1).getPosts());
        model.addAttribute("postsByViews", communityPostService.getPostsByViews());
        return "/community-list/community-posts";
    }

    //    게시글 작성
    @GetMapping("failure-write")
    public String goToFailureWrite(PostDTO postDTO, Model model) {
        model.addAttribute(postDTO);
        return "/community-list/failure-write";
    }

    @PostMapping("failure-write")
    public RedirectView write(PostDTO postDTO){
        postDTO.setMemberId(1L); // 임시 회원
        communityPostService.write(postDTO);
        return new RedirectView("/community-list/" + postDTO.getId());
    }

    //    게시글 작성자 기준 조회
    @GetMapping(value = "{id}")
    public String readPostWriter(@PathVariable Long id, Model model) {
        model.addAttribute("post", communityPostService.getPost(id).orElseThrow(PostNotFoundException::new));
        return "/community-list/community-contents-writer";
    }

    //    게시글 수정
    @GetMapping(value = "failure-update/{id}")
    public String goToUpdatePost(@PathVariable Long id, Model model) {
        model.addAttribute("post", communityPostService.getPost(id).orElseThrow(PostNotFoundException::new));
        return "/community-list/failure-update";
    }

    @PostMapping("failure-update")
    public RedirectView updatePost(PostDTO postDTO) {
        postDTO.setMemberId(1L); // 임시 회원
        communityPostService.updatePost(postDTO);
        return new RedirectView("/community-list/" + postDTO.getId());
    }
}
