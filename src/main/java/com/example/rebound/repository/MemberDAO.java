package com.example.rebound.repository;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
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



    //    조회
    public MemberDTO selectMemberById(int memberId) {
        return memberMapper.selectMemberById(memberId);
    }
    //    관리자 조회
    public MemberDTO isExistAdmin(MemberDTO memberDTO) {
        return memberMapper.selectAdmin(memberDTO);
    }
    public List<MemberDTO> findGeneralMemberAll() {
        return memberMapper.selectGeneralAll();
    }
}
