package com.example.rebound.service;

import com.example.rebound.dto.MemberDTO;

import java.util.List;

public interface AdminService {
    public MemberDTO checkAdmin(MemberDTO memberDTO);
    public List<MemberDTO> findGeneralMembers();
}
