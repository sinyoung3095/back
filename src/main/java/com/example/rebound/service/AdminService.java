package com.example.rebound.service;

import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.util.MemberCriteria;

import java.util.List;

public interface AdminService {
    //    관리자 확인
    public MemberDTO checkAdmin(MemberDTO memberDTO);
//    일반 회원 전체 조회
    public MemberCriteriaDTO findGeneralMembers(int page,String keyword);

}
