package com.example.rebound.repository;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.mapper.CounselorMapper;
import com.example.rebound.util.MemberCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

//    상담사 이름 변경
    public void counselorRename(CounselorDTO counselorDTO) { counselorMapper.updateCounselorName(counselorDTO);}
//    상담사 전화번호 변경
    public void updateCounselorPhoneNumber(CounselorDTO counselorDTO){
        counselorMapper.updateCounselorPhoneNumber(counselorDTO);
    }
//    상담사 이메일 변경
    public void updateCounselorEmail(CounselorDTO counselorDTO){
        counselorMapper.updateCounselorEmail(counselorDTO);
    }

//    상담사 조회
    public Optional<CounselorDTO> findCounselorByEmailAndPassword(CounselorDTO counselorDTO){
        return counselorMapper.selectCounselor(counselorDTO);
    }
    public Optional<CounselorDTO> selectCounselorById(Long id){
        return counselorMapper.selectCounselorById(id);
    }
//     상담사 통합검색
    public List<CounselorDTO> findCounselorAll(MemberCriteria memberCriteria,String keyword){
        return counselorMapper.selectCounselorAll(memberCriteria,keyword);
    }
//    상담사 수 통합검색
    public int findCounselorAllCount(String keyword){
        return counselorMapper.selectCounselorAllCount(keyword);
}
//  상담사 자격 승인 여부
    public List<CounselorDTO> findCounselorQualificationAll(MemberCriteria memberCriteria,String keyword){
        return counselorMapper.selectCounselorQualificationAll(memberCriteria,keyword);
    }
//  상담사 자격 승인 여부
public int findCounselorQualificationAllCount(String keyword){
    return counselorMapper.selectCounselorQualificationAllCount(keyword);
}
    public void setLatelyDate(String counselorEmail) {
        counselorMapper.updateLatelyDate(counselorEmail);
    }

    public void updateCounselorPassword(String counselorPassword, String counselorEmail) {
        counselorMapper.updateCounselorPassword(counselorPassword, counselorEmail);
    }

    public CounselorDTO selectEmailByPhoneNumber(String counselorPhoneNumber) {
        return counselorMapper.selectEmailByPhoneNumber(counselorPhoneNumber);
    }
}
