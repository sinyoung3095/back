package com.example.rebound.repository;

import com.example.rebound.dto.MemberProfileFileDTO;
import com.example.rebound.mapper.MemberMapper;
import com.example.rebound.mapper.MemberProfileFileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberProfileFileDAO {
    private final MemberProfileFileMapper memberProfileFileMapper;

    public void saveMemberProfileFile(MemberProfileFileDTO memberProfileFileDTO) {
        memberProfileFileMapper.insertMemberProfileFile(memberProfileFileDTO);
    }
}
