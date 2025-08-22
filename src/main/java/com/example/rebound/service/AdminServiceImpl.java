package com.example.rebound.service;

import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.repository.MemberDAO;
import com.example.rebound.repository.PostDAO;
import com.example.rebound.util.MemberCriteria;
import com.example.rebound.util.PostCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final MemberDAO  memberDAO;
    private final PostDAO postDAO;
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
        memberCriteriaDTO.setPosts();

        List<MemberDTO> members = memberDAO.findSubscribeMemberAll(memberCriteria,keyword);

        memberCriteria.setHasMore(members.size() > memberCriteria.getRowCount());
        return memberCriteriaDTO;
    }
    }


}
