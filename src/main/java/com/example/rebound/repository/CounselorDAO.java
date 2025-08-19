package com.example.rebound.repository;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.mapper.CounselorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CounselorDAO {
    private final CounselorMapper counselorMapper;

    //    상담사 추가
    public void saveCounselor(CounselorDTO counselorDTO) {counselorMapper.insertCounselor(counselorDTO);}
    
    public List<CounselorDTO> getCounselorLists() { return counselorMapper.getCounselors(); }

    //    이메일 중복 검사
    public boolean isExistCounselorEmail(String counselorEmail){
        return counselorMapper.existCounselorEmail(counselorEmail);
    }

    //    전화번호 중복 검사
    public boolean isExistCounselorPhoneNumber(String counselorPhoneNumber){return counselorMapper.existCounselorPhoneNumber(counselorPhoneNumber);}
}
