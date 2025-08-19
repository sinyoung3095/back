package com.example.rebound.controller;

import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/list/**")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    @GetMapping("{page}")
    public MemberCriteriaDTO GeneralFindAll(@PathVariable int page) {
        return adminService.findGeneralMembers(page);
    }
//    @GetMapping("{page}}")
//    public List<MemberDTO> find(@PathVariable("page") int page){
//        MemberCriteriaDTO memberCriteriaDTO = adminService.findGeneralMembers(page);
//        return memberCriteriaDTO.getMembers();
//    };

}
