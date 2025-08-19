package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface CounselorService {
    //    상담사 회원가입
    public void joinCounselor(CounselorDTO counselorDTO, List<MultipartFile> files);

    //    상담사 이메일 중복 검사
    public boolean isExistCounselorEmail(String counselorEmail);
    //    상담사 중복 검사
    public boolean isExistCounselorPhoneNumber(String counselorPhoneNumber);

    default String getPath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
