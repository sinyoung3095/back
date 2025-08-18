package com.example.rebound.service;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.repository.MemberDAO;
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
    public List<MemberDTO> findGeneralMembers() {
        return memberDAO.findGeneralMemberAll();
    }
}
