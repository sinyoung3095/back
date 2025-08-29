package com.example.rebound.mapper;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.CounselorProfileFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface CounselorProfileFileMapper {
//    추가
    public void insertCounselorProfileFile(CounselorProfileFileDTO counselorProfileFileDTO);
//    조회
    public Optional<FileDTO> selectCounselorProfileFileByCounselorId(Long id);
//    삭제
    public void deleteCounselorProfileById(Long id);
}
