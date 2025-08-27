package com.example.rebound.controller;

import com.example.rebound.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/**")
public class FileController {
    MemberService memberService;
    @GetMapping("display")
    public byte[] display(String filePath, String fileName) throws IOException {
//        log.info("{}, {}", filePath, fileName);
        return FileCopyUtils.copyToByteArray(new File("C:/reboundFile/"+filePath, fileName));
    }
    @GetMapping("delete/{id}")
    public void deleteMemberProfileFile(@PathVariable Long id) throws IOException {
        memberService.deleteProfile(id);
    }
}
