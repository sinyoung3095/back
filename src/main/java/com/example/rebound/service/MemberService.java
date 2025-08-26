package com.example.rebound.service;

import com.example.rebound.dto.MemberDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public interface MemberService {
//    회원 회원가입
    public void joinMember(MemberDTO memberDTO);
//    회원 이메일 중복 검사
    public boolean isExistMemberEmail(String memberEmail);
//    회원 번호 중복 검사
    public boolean isExistMemberPhoneNumber(String memberPhoneNumber);
//    회원 로그인
    public Optional<MemberDTO> login(MemberDTO memberDTO);
//    카카오 기존 회원 정보 조회
    public Optional<MemberDTO> findMemberByKakaoEmail(String kakaoEmail);
//    카카오 회원가입
    public void joinKakaoMember(MemberDTO memberDTO);
//    카카오 프로필 저장
    public void saveKakaoProfile(MemberDTO memberDTO);
//    프로필 사진 조회
    public Optional<MemberDTO> showFileById(Long id);

    default String getPath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
//    회원 이름 수정
    public void memberRename(MemberDTO memberDTO);
//    회원 프로필 사진 삭제
    public void deleteProfile(Long id);
//    회원 비밀번호 변경
    public void updateMemberPassword(String memberPassword, String memberEmail);
}
