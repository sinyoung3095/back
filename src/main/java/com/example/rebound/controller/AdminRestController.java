package com.example.rebound.controller;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/general/**")
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;

    @GetMapping("find")
    public List<MemberDTO> GeneralFindAll() {
        return adminService.findGeneralMembers();
    }
//    @GetMapping("{page}}")
//    public List<MemberDTO> find(@PathVariable("page") int page){
//        MemberCriteriaDTO memberCriteriaDTO = adminService.findGeneralMembers(page);
//        return memberCriteriaDTO.getMembers();
//    };

}
