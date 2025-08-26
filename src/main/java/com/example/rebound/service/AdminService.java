package com.example.rebound.service;

import com.example.rebound.dto.*;
import com.example.rebound.util.MemberCriteria;

import java.util.List;

public interface AdminService {
    //    관리자 확인
    public MemberDTO checkAdmin(MemberDTO memberDTO);
//    일반 회원 조회
    public MemberCriteriaDTO findGeneralMembers(int page,String keyword);

//    멘토 회원 조회
    public MemberCriteriaDTO findMentorMembers(int page,String keyword);
//    구독 회원 조회
    public MemberCriteriaDTO findSubscribeMembers(int page,String keyword);
//    게시글 조회
    public List<PostDTO> postsAllByKeyword(String keyword);
//    댓글 조회
    public List<CommentDTO> commentsAllByKeyword(String keyword);
//    상담사 회원 조회
    public CounselorCriteriaDTO findCounselorMembers(int page,String keyword);
//    상담사 자격 승인 여부
    public CounselorCriteriaDTO findCounselorQualifications(int page,String keyword);
//    공지사항 리스트
    public NoticeCriteriaDTO findNoticeAll(int page);
//    공지사항 상세 조회
    public NoticeDTO noticeDetail(int id);

}
