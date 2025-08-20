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

    @GetMapping("general/{page}")
    public MemberCriteriaDTO GeneralFindAll(@PathVariable int page,@RequestParam(required = false) String keyword) {
        System.out.println(keyword);
        return adminService.findGeneralMembers(page,keyword);
    }
//

}
