package com.example.rebound.mapper;


import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.util.MemberCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import com.example.rebound.dto.MemberDTO;
import com.example.rebound.util.MemberCriteria;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;


import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    //    추가
    public void insertMember(MemberDTO memberDTO);
//    이메일 중복 검사
    @Select("select count(*) > 0 from tbl_member where member_email = #{memberEmail}")
    public boolean existMemberEmail(String memberEmail);
//    전화번호 중복 검사
    @Select("select count(*)>0 from app.tbl_member where member_phone_number=#{memberPhoneNumber}")
    public boolean existMemberPhoneNumber(String memberPhoneNumber);
//    로그인
    public Optional<MemberDTO> selectMember(MemberDTO memberDTO);
//    카카오 이메일 중복 검사
    public Optional<MemberDTO> selectMemberByKakaoEmail(String kakaoEmail);
//    카카오 추가
    public void insertKakaoMember(MemberDTO memberDTO);
    //    조회
    public MemberDTO selectMemberById(int memberId);
    //    관리자 조회
    public MemberDTO selectAdmin(MemberDTO memberDTO );
    //    일반 회원 모두 조회
    public List<MemberDTO> selectGeneralAll(@Param("memberCriteria") MemberCriteria memberCriteria,@Param("keyword") String keyword);
    //    일반 회원 전체 수 조회
    public int selectGeneralAllCount(String keyword);
    //    수정
    public void updateMember(Member member);
    //    삭제
    public void deleteMemberById(int memberId);
}
