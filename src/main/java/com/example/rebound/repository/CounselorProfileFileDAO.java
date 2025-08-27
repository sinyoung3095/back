package com.example.rebound.repository;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.CounselorProfileFileDTO;
import com.example.rebound.mapper.CounselorProfileFileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CounselorProfileFileDAO {
    private final CounselorProfileFileMapper counselorProfileFileMapper;

//    추가
    public void saveCounselorProfileFile(CounselorProfileFileDTO counselorProfileFileDTO) {
        counselorProfileFileMapper.insertCounselorProfileFile(counselorProfileFileDTO);
    }

//    조회
    public Optional<FileDTO> findCounselorProfileFileById(Long id) {
        return counselorProfileFileMapper.findCounselorProfileFileById(id);
    }
//    삭제
    public void deleteCounselorProfileById(Long id) {
        counselorProfileFileMapper.deleteCounselorProfileById(id);
    }
}
