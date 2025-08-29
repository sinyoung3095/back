package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.MemberDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public interface CounselorService {
    //    상담사 회원가입
    public void joinCounselor(CounselorDTO counselorDTO, List<MultipartFile> files);

    //    상담사 이메일 중복 검사
    public boolean isExistCounselorEmail(String counselorEmail);
    //    상담사 중복 검사
    public boolean isExistCounselorPhoneNumber(String counselorPhoneNumber);
//    상담사 로그인
    public Optional<CounselorDTO> login(CounselorDTO counselorDTO);

    default String getPath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
//    상담사 프로필 사진 조회
    public Optional<CounselorDTO> showFileById(Long counselorId);
//    상담사 이름 변경
    public void counselorRename(CounselorDTO counselorDTO);

    public FileDTO saveCounselorProfileFile(MultipartFile file, Long counselorId) throws IOException;

    public void deleteProfile(Long id);

    public void updateCounselorPhoneNumber(CounselorDTO counselorDTO);

    public void updateCounselorEmail(CounselorDTO counselorDTO);
}
