package com.example.rebound.mapper;

import com.example.rebound.dto.CounselorQualificationsFileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CounselorQualificationsFileMapper {
//    추가
    public void insertCounselorQualificationsFile(CounselorQualificationsFileDTO counselorQualificationsFileDTO);
}
