package com.example.rebound.mapper;

import com.example.rebound.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Member;

@Mapper
public interface MemberMapper {
    //    추가
    public void insertMember(MemberDTO memberDTO);
    //    조회
    public MemberDTO selectMemberById(int memberId);
    //    수정
    public void updateMember(Member member);
    //    삭제
    public void deleteMemberById(int memberId);
}
