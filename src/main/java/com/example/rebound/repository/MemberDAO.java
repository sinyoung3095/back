package com.example.rebound.repository;

import com.example.rebound.domain.MemberVO;
import com.example.rebound.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    //    추가
    public void save(MemberVO memberVO) {
        memberMapper.insertMember(memberVO);
    }

    //    조회
    public MemberVO selectMemberById(int memberId) {
        return memberMapper.selectMemberById(memberId);
    }
}
