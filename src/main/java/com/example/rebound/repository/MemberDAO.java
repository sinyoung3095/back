package com.example.rebound.repository;

import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.mapper.MemberMapper;
import com.example.rebound.util.MemberCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    //    관리자 조회
    public MemberDTO isExistAdmin(MemberDTO memberDTO) {
        return memberMapper.selectAdmin(memberDTO);
    }
    //    일반 회원 전체 조회
    public List<MemberDTO> findGeneralMemberAll(MemberCriteria memberCriteria) {
        return memberMapper.selectGeneralAll(memberCriteria);
    }
    //    일반 회원 전체 수 조회
    public int countGeneralMemberAll() {
        return memberMapper.selectGeneralAllCount();
    }
}
