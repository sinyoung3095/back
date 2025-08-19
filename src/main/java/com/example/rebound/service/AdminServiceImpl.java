package com.example.rebound.service;

import com.example.rebound.dto.MemberCriteriaDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.repository.MemberDAO;
import com.example.rebound.util.MemberCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final MemberDAO  memberDAO;
    @Override
    public MemberDTO checkAdmin(MemberDTO memberDTO) {

        return memberDAO.isExistAdmin(memberDTO);
    }

    @Override
    public MemberCriteriaDTO findGeneralMembers(int page) {
        MemberCriteriaDTO memberCriteriaDTO = new MemberCriteriaDTO();
        MemberCriteria memberCriteria = new MemberCriteria(page,memberDAO.countGeneralMemberAll());
        memberCriteriaDTO.setMembers(memberDAO.findGeneralMemberAll(memberCriteria));
        memberCriteriaDTO.setMemberCriteria(memberCriteria);

        List<MemberDTO> members = memberDAO.findGeneralMemberAll(memberCriteria);



        memberCriteria.setHasMore(members.size() > memberCriteria.getRowCount());
        return memberCriteriaDTO;
    }

    @Override
    public int countGeneralMembers() {
        return memberDAO.countGeneralMemberAll();
    }

}
