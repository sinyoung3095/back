package com.example.rebound.service;

import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.util.MemberCriteria;

import java.util.List;

public interface AdminService {
    //    관리자 확인
    public MemberDTO checkAdmin(MemberDTO memberDTO);
//    일반 회원 전체 조회
    public MemberCriteriaDTO findGeneralMembers(int page,String keyword);

//    멘토 회원 전체 조회
    public MemberCriteriaDTO findMentorMembers(int page,String keyword);
//    구독 회원 전체 조회
    public MemberCriteriaDTO findSubscribeMembers(int page,String keyword);
//    keyword로 post 조회
    public PostCriteriaDTO findPosts(int page,String keyword);
}
