package com.example.rebound.mapper;

import com.example.rebound.dto.CounselorQualificationsFileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CounselorQualificationsFileMapper {
//    추가
    public void insertCounselorQualificationsFile(CounselorQualificationsFileDTO counselorQualificationsFileDTO);

}
