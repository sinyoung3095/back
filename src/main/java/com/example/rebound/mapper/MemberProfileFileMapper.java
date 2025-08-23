package com.example.rebound.mapper;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.MemberProfileFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberProfileFileMapper {
    public void insertMemberProfileFile(MemberProfileFileDTO memberProfileFileDTO);
//    조회
    public Optional<FileDTO> findMemberProfileFileById(Long id);
}
