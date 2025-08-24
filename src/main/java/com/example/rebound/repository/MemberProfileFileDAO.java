package com.example.rebound.repository;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.MemberProfileFileDTO;
import com.example.rebound.mapper.MemberMapper;
import com.example.rebound.mapper.MemberProfileFileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberProfileFileDAO {
    private final MemberProfileFileMapper memberProfileFileMapper;

//    추가
    public void saveMemberProfileFile(MemberProfileFileDTO memberProfileFileDTO) {
        memberProfileFileMapper.insertMemberProfileFile(memberProfileFileDTO);
    }

//    조회
    public Optional<FileDTO> findMemberProfileFileById(Long id) {
        return memberProfileFileMapper.findMemberProfileFileById(id);
    }
}
