package com.example.rebound.repository;

import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.CounselorDTO;
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
    public Optional<MemberDTO> selectMemberById(Long memberId) {
        return memberMapper.selectMemberById(memberId);
    }

//    이름 수정
    public void memberRename(MemberDTO memberDTO){
        memberMapper.updateMemberName(memberDTO);
    }
    //    관리자 조회
    public MemberDTO isExistAdmin(MemberDTO memberDTO) {
        return memberMapper.selectAdmin(memberDTO);
    }
    //    일반 회원 전체 조회
    public List<MemberDTO> findGeneralMemberAll(MemberCriteria memberCriteria, String keyword) {
        System.out.println("DAO일반 회원 전체:"+keyword);
        return memberMapper.selectGeneralAll(memberCriteria,keyword);
    }
    //    일반 회원 전체 수 조회
    public int countGeneralMemberAll(String keyword) {
        System.out.println("DAO일반 회원 전체 수:"+keyword);
        return memberMapper.selectGeneralAllCount(keyword);
    }
    //    멘토 회원 전체 조회
    public List<MemberDTO> findMentorMemberAll(MemberCriteria memberCriteria, String keyword) {
        return memberMapper.selectMentorAll(memberCriteria,keyword);
    }
    //    멘토 회원 전체 수 조회
    public int countMentorMemberAll(String keyword) {
        return memberMapper.selectMentorAllCount(keyword);
    }
    //    구독 회원 전체 조회
    public List<MemberDTO> findSubscribeMemberAll(MemberCriteria memberCriteria, String keyword) {
        return memberMapper.selectSubscribeAll(memberCriteria,keyword);
    }
    //    구독 회원 전체 수 조회
    public int countSubscribeMemberAll(String keyword) {
        return memberMapper.selectSubscribeAllCount(keyword);
    }
    //    이메일(카카오이메일 포함)로 조회
    public MemberDTO findMemberByEmail(String memberEmail) {
        return memberMapper.selectByMemberEmail(memberEmail);
    }
    //    회원 비밀번호 변경
    public void updateMemberPassword(String memberPassword, String memberEmail) {
        memberMapper.updateMemberPassword(memberPassword, memberEmail);
    }

    //    회원 이메일 찾기
    public MemberDTO selectEmailByPhonerNumber(String memberPhoneNumber) {
        return memberMapper.selectEmailByPhonerNumber(memberPhoneNumber);
    }
    public int findCountByYear(String year) {
        return memberMapper.selectCountGradeByYear(year);
    }
    public int findCountByMonth(String month) {
        return memberMapper.selectCountGradeByMonth(month);
    }
    public int findSubscribeCountByYear(String year) {
        return memberMapper.selectCountSubscribeByYear(year);
    }
    public int findSubscribeCountByMonth(String month) {
        return memberMapper.selectCountSubscribeByMonth(month);
    }
    public void setLatelyDate(Long Id) {
        memberMapper.updateLatelyDate(Id);
    }
}
