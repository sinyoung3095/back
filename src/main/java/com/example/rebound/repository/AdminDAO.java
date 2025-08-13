package com.example.rebound.repository;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
    private final AdminMapper adminMapper;

    //    이메일 검사
    public MemberDTO isExistMemberEmail(MemberDTO memberDTO){
        return adminMapper.selectAdmin(memberDTO);
    }


////    로그인
//    public Optional<MemberDTO> findMemberByMemberEmailAndMemberPassword(MemberDTO memberDTO){
//        return memberMapper.selectMemberForLogin(memberDTO);
//    }
}
