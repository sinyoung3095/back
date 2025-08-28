package com.example.rebound.controller;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.dto.MemberProfileFileDTO;
import com.example.rebound.repository.MemberProfileFileDAO;
import com.example.rebound.service.CounselorService;
import com.example.rebound.service.FileService;
import com.example.rebound.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/**")
public class FileController {
    private final CounselorService counselorService;
    private final MemberService memberService;
    private final MemberProfileFileDAO memberProfileFileDAO;
    private final FileService fileService;

    @GetMapping("display")
    public ResponseEntity<byte[]> display(String filePath, String fileName) {
        File file = new File("C:/reboundFile/" + filePath, fileName);
        if (!file.exists() || !file.isFile()) {
            return ResponseEntity.notFound().build();
        }

        try {
            byte[] fileBytes = FileCopyUtils.copyToByteArray(file);
            return ResponseEntity.ok(fileBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteMemberProfileFile(@PathVariable Long id) {
        try {
            memberService.deleteProfile(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("회원 프로필 삭제 실패: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("delete-counselor/{id}")
    public ResponseEntity<Void> deleteCounselorProfileFile(@PathVariable Long id) {
        try {
            counselorService.deleteProfile(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("상담사 프로필 삭제 실패: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/profile/upload")
    public ResponseEntity<FileDTO> uploadProfile(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("memberId") Long memberId) throws IOException {
        if(fileService.findFileByMemberId(memberId).isPresent()) {
            memberService.deleteProfile(memberId);
        }
        System.out.println(fileService.findFileByMemberId(memberId).isPresent());
        FileDTO fileDTO = memberService.saveProfileFile(file, memberId);
        return ResponseEntity.ok(fileDTO);
    }


}
