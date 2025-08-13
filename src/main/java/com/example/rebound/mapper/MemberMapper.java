package com.example.rebound.mapper;

import com.example.rebound.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Member;

@Mapper
public interface MemberMapper {
    //    추가
    public void insertMember(MemberDTO memberDTO);
//    이메일 중복 검사
    @Select("select count(*) > 0 from tbl_member where member_email = #{memberEmail}")
    public boolean existMemberEmail(String memberEmail);
    //    조회
    public MemberDTO selectMemberById(int memberId);
    //    관리자 조회
    public MemberDTO selectAdmin(MemberDTO memberDTO );
    //    수정
    public void updateMember(Member member);
    //    삭제
    public void deleteMemberById(int memberId);
}
