package com.example.rebound.repository;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    //    추가
    public void save(MemberDTO memberDTO) {
        memberMapper.insertMember(memberDTO);
    }

    //    조회
    public MemberDTO selectMemberById(int memberId) {
        return memberMapper.selectMemberById(memberId);
    }
}
