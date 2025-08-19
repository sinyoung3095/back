package com.example.rebound.mapper;

import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.util.MemberCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Member;
import java.util.List;

@Mapper
public interface MemberMapper {
    //    추가
    public void insertMember(MemberDTO memberDTO);
    //    조회
    public MemberDTO selectMemberById(int memberId);
    //    관리자 조회
    public MemberDTO selectAdmin(MemberDTO memberDTO );
    //    일반 회원 모두 조회
    public List<MemberDTO> selectGeneralAll(@Param("memberCriteria") MemberCriteria memberCriteria);
    //    일반 회원 전체 수 조회
    public int selectGeneralAllCount();
    //    수정
    public void updateMember(Member member);
    //    삭제
    public void deleteMemberById(int memberId);
}
