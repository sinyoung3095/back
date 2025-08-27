package com.example.rebound.mapper;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FileMapper {
//    추가
    public void insertFile(FileDTO fileDTO);
//    조회
    public Optional<FileDTO> selectFileById(Long id);
    Optional<FileDTO> selectFileByMemberId(Long memberId);
    public Optional<FileDTO> selectFileByCounselorId(Long counselorId);
//    삭제
    public void deleteFileById(Long id);
}
