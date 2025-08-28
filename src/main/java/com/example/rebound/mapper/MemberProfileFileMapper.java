package com.example.rebound.mapper;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.MemberProfileFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberProfileFileMapper {
//    추가
    public void insertMemberProfileFile(MemberProfileFileDTO memberProfileFileDTO);
//    조회
    public Optional<FileDTO> selectMemberProfileFileByMemberId(Long id);
//    삭제
    public void deleteMemberProfileById(Long id);
}
