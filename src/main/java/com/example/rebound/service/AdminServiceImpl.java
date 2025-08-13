package com.example.rebound.service;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.repository.AdminDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;
    @Override
    public MemberDTO checkAdmin(MemberDTO memberDTO) {

        return adminDAO.isExistMemberEmail(memberDTO);
    }
}
