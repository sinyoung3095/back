package com.example.rebound.repository;


<<<<<<< HEAD
import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.CounselorDTO;
=======
>>>>>>> master
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.mapper.MemberMapper;
import com.example.rebound.util.MemberCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDAO {
    private final MemberMapper memberMapper;

    //    추가
    public void save(MemberDTO memberDTO) {
        memberMapper.insertMember(memberDTO);
    }

//    이메일 중복 검사
    public boolean isExistMemberEmail(String memberEmail){
        return memberMapper.existMemberEmail(memberEmail);
    }

//    전화번호 중복 검사
    public boolean isExistMemberPhoneNumber(String memberPhoneNumber){return memberMapper.existMemberPhoneNumber(memberPhoneNumber);}


//    로그인
    public Optional<MemberDTO> findMemberByEmailAndPassword(MemberDTO memberDTO){
        return memberMapper.selectMember(memberDTO);
    }

//    카카오 계정 기존 이메일과 중복인지 검사
    public Optional<MemberDTO> findMemberByKakaoEmail(String kakaoEmail){
        return memberMapper.selectMemberByKakaoEmail(kakaoEmail);
    }
    //    카카오 회원가입
    public void saveKakaoMember(MemberDTO memberDTO){
        memberMapper.insertKakaoMember(memberDTO);
    }


    //    조회
    public MemberDTO selectMemberById(int memberId) {
        return memberMapper.selectMemberById(memberId);
    }
    //    관리자 조회
    public MemberDTO isExistAdmin(MemberDTO memberDTO) {
        return memberMapper.selectAdmin(memberDTO);
    }
    //    일반 회원 전체 조회
    public List<MemberDTO> findGeneralMemberAll(MemberCriteria memberCriteria, String keyword) {
        return memberMapper.selectGeneralAll(memberCriteria,keyword);
    }
    //    일반 회원 전체 수 조회
    public int countGeneralMemberAll(String keyword) {
        System.out.println(keyword);
        return memberMapper.selectGeneralAllCount(keyword);
    }
}
