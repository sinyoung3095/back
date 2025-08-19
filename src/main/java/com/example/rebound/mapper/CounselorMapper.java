package com.example.rebound.mapper;

import com.example.rebound.dto.CounselorDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CounselorMapper {
    public List<CounselorDTO> getCounselors();
    //    상담사 추가
    public void insertCounselor(CounselorDTO counselorDTO);
}
