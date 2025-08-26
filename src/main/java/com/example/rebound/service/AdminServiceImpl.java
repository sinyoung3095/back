package com.example.rebound.service;

import com.example.rebound.dto.*;
import com.example.rebound.repository.*;
import com.example.rebound.util.MemberCriteria;
import com.example.rebound.util.PostCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AdminServiceImpl implements AdminService {
    private final MemberDAO  memberDAO;
    private final PostDAO postDAO;
    private final PostDTO postDTO;
    private final CommentDAO commentDAO;
    private final CounselorDAO  counselorDAO;
    private final NoticeDAO noticeDAO;

    @Override
    public MemberDTO checkAdmin(MemberDTO memberDTO) {

        return memberDAO.isExistAdmin(memberDTO);
    }

    @Override
    public MemberCriteriaDTO findGeneralMembers(int page,String keyword) {
        MemberCriteriaDTO memberCriteriaDTO = new MemberCriteriaDTO();
        MemberCriteria memberCriteria = new MemberCriteria(page,memberDAO.countGeneralMemberAll(keyword));
        memberCriteriaDTO.setMembers(memberDAO.findGeneralMemberAll(memberCriteria,keyword));
        memberCriteriaDTO.setMemberCriteria(memberCriteria);

        List<MemberDTO> members = memberDAO.findGeneralMemberAll(memberCriteria,keyword);

        memberCriteria.setHasMore(members.size() > memberCriteria.getRowCount());
        memberCriteriaDTO.getMembers().forEach((member)->{
            String[] word = member.getCreatedDate().split(" ");
            member.setCreatedDate(word[0]);});


        return memberCriteriaDTO;
    }

    @Override
    public MemberCriteriaDTO findMentorMembers(int page, String keyword) {
        MemberCriteriaDTO memberCriteriaDTO = new MemberCriteriaDTO();
        MemberCriteria memberCriteria = new MemberCriteria(page,memberDAO.countMentorMemberAll(keyword));
        memberCriteriaDTO.setMembers(memberDAO.findMentorMemberAll(memberCriteria,keyword));
        memberCriteriaDTO.setMemberCriteria(memberCriteria);

        List<MemberDTO> members = memberDAO.findMentorMemberAll(memberCriteria,keyword);

        memberCriteria.setHasMore(members.size() > memberCriteria.getRowCount());
        memberCriteriaDTO.getMembers().forEach((member)->{
            String[] word = member.getCreatedDate().split(" ");
            member.setCreatedDate(word[0]);});
        return memberCriteriaDTO;
    }

    @Override
    public MemberCriteriaDTO findSubscribeMembers(int page, String keyword) {
        MemberCriteriaDTO memberCriteriaDTO = new MemberCriteriaDTO();
        MemberCriteria memberCriteria = new MemberCriteria(page,memberDAO.countSubscribeMemberAll(keyword));
        memberCriteriaDTO.setMembers(memberDAO.findSubscribeMemberAll(memberCriteria,keyword));
        memberCriteriaDTO.setMemberCriteria(memberCriteria);
        List<MemberDTO> members = memberDAO.findSubscribeMemberAll(memberCriteria,keyword);
        memberCriteria.setHasMore(members.size() > memberCriteria.getRowCount());

        memberCriteriaDTO.getMembers().forEach((member)->{
            String[] word = member.getCreatedDate().split(" ");
            member.setCreatedDate(word[0]);});
        return memberCriteriaDTO;
    }

    @Override
    public List<PostDTO> postsAllByKeyword(String keyword) {
        List<PostDTO> posts = postDAO.findAllByKeyword(keyword);
        posts.forEach((post)->{
            String[] word = post.getCreatedDate().split(" ");
            post.setCreatedDate(word[0]);
        });
        return posts;
    }

    @Override
    public List<CommentDTO> commentsAllByKeyword(String keyword) {
        List<CommentDTO>  comments = commentDAO.findAllByKeyword(keyword);
        comments.forEach((comment)->{
            String[] word = comment.getCreatedDate().split(" ");
            comment.setCreatedDate(word[0]);
        });

        return comments;
    }

    @Override
    public CounselorCriteriaDTO findCounselorMembers(int page, String keyword) {
        CounselorCriteriaDTO counselorCriteriaDTO = new CounselorCriteriaDTO();
        MemberCriteria memberCriteria = new MemberCriteria(page,counselorDAO.findCounselorAllCount(keyword));
        counselorCriteriaDTO.setCounselors(counselorDAO.findCounselorAll(memberCriteria,keyword));
        counselorCriteriaDTO.setMemberCriteria(memberCriteria);
        List<CounselorDTO> counselors = counselorDAO.findCounselorAll(memberCriteria,keyword);
        memberCriteria.setHasMore(counselors.size() > memberCriteria.getRowCount());
        counselorCriteriaDTO.getCounselors().forEach((counselor)->{
            String[] word = counselor.getCreatedDate().split(" ");
            counselor.setCreatedDate(word[0]);
        });
        return counselorCriteriaDTO;
    }

    @Override
    public CounselorCriteriaDTO findCounselorQualifications(int page, String keyword) {
        CounselorCriteriaDTO counselorCriteriaDTO = new CounselorCriteriaDTO();
        MemberCriteria memberCriteria = new MemberCriteria(page,counselorDAO.findCounselorQualificationAllCount(keyword));
        counselorCriteriaDTO.setCounselors(counselorDAO.findCounselorQualificationAll(memberCriteria,keyword));
        counselorCriteriaDTO.setMemberCriteria(memberCriteria);

        List<CounselorDTO> counselors = counselorDAO.findCounselorQualificationAll(memberCriteria,keyword);



        memberCriteria.setHasMore(counselors.size() > memberCriteria.getRowCount());
        return counselorCriteriaDTO;
    }

    @Override
    public NoticeCriteriaDTO findNoticeAll(int page) {
        NoticeCriteriaDTO noticeCriteriaDTO = new NoticeCriteriaDTO();
        MemberCriteria memberCriteria = new MemberCriteria(page,noticeDAO.findNoticeCount());
        noticeCriteriaDTO.setNotices(noticeDAO.findNoticeAll(memberCriteria));
        noticeCriteriaDTO.setMemberCriteria(memberCriteria);
        List<NoticeDTO> notices = noticeDAO.findNoticeAll(memberCriteria);
        memberCriteria.setHasMore(notices.size() > memberCriteria.getRowCount());
        noticeCriteriaDTO.getNotices().forEach((notice)->{
            String[] word = notice.getCreatedDate().split(" ");
            notice.setCreatedDate(word[0]);
        });

        return noticeCriteriaDTO;
    }

    @Override
    public NoticeDTO noticeDetail(int id) {

        return noticeDAO.findNoticeById(id);
    }


}
