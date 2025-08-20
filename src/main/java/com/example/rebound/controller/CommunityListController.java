package com.example.rebound.controller;

import com.example.rebound.common.exception.PostNotFoundException;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.service.CommunityListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/community-list/**")
@RequiredArgsConstructor
public class CommunityListController {
    private final CommunityListService communityPostService;

    //    작성
    @GetMapping("failure-write")
    public String goToFailureWrite(PostDTO postDTO, Model model) {
        model.addAttribute(postDTO);
        return "/community-list/failure-write";
    }

    @PostMapping("failure-write")
    public String write(PostDTO postDTO) {
        postDTO.setMemberId(1L); // 임시 회원
        Long id = communityPostService.write(postDTO);
        return "redirect:/community-list/" + id;
    }

//    @PostMapping("failure-write")
//    public RedirectView write(PostDTO postDTO){
//        postService.write(postDTO);
//        return new RedirectView("/community-list/" + postDTO.getId());
//    }

    //    조회
    @GetMapping("{id}")
    public String readPostWriter(@PathVariable Long id, Model model) {
        model.addAttribute("post", communityPostService.getPost(id).orElseThrow(PostNotFoundException::new));
        return "/community-list/community-contents-writer";
    }

    //    게시글 목록
    @GetMapping("community-posts")
    public String showPosts(Model model) {
        List<PostDTO> posts = communityPostService.findPostsCriteria(1).getPosts();
        model.addAttribute("posts", posts);
        return "/community-list/community-posts";
    }



    @GetMapping("community-contents-member")
    public String goToCommunityContentsMember() {
        return "/community-list/community-contents-member";
    }
}
