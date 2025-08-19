package com.example.rebound.repository;

import com.example.rebound.dto.CounselorQualificationsFileDTO;
import com.example.rebound.mapper.CounselorQualificationsFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CounselorQualificationsFileDAO {
    final CounselorQualificationsFileMapper counselorQualificationsFileMapper;

    public void saveCounselorQualificationsFile(CounselorQualificationsFileDTO counselorQualificationsFileDTO){
        counselorQualificationsFileMapper.insertCounselorQualificationsFile(counselorQualificationsFileDTO);
    }
}
