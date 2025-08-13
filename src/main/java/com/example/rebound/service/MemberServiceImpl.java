package com.example.rebound.service;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    @Override
    public void joinMember(MemberDTO memberDTO) {
        memberDAO.save(memberDTO);
    }
}
