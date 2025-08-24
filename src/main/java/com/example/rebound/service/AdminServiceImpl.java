package com.example.rebound.service;

import com.example.rebound.dto.*;
import com.example.rebound.repository.CommentDAO;
import com.example.rebound.repository.CounselorDAO;
import com.example.rebound.repository.MemberDAO;
import com.example.rebound.repository.PostDAO;
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
        return memberCriteriaDTO;
    }

    @Override
    public List<PostDTO> postsAllByKeyword(String keyword) {

        return postDAO.findAllByKeyword(keyword);
    }

    @Override
    public List<CommentDTO> commentsAllByKeyword(String keyword) {
        System.out.println("서비스:"+keyword);
        return commentDAO.findAllByKeyword(keyword);
    }

    @Override
    public CounselorCriteriaDTO findCounselorMembers(int page, String keyword) {
        CounselorCriteriaDTO counselorCriteriaDTO = new CounselorCriteriaDTO();
        MemberCriteria memberCriteria = new MemberCriteria(page,counselorDAO.findCounselorAllCount(keyword));
        counselorCriteriaDTO.setCounselors(counselorDAO.findCounselorAll(memberCriteria,keyword));
        counselorCriteriaDTO.setMemberCriteria(memberCriteria);

        List<CounselorDTO> counselors = counselorDAO.findCounselorAll(memberCriteria,keyword);



        memberCriteria.setHasMore(counselors.size() > memberCriteria.getRowCount());
        return counselorCriteriaDTO;
    }


}
