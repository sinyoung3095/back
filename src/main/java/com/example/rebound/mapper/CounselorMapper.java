package com.example.rebound.mapper;

import com.example.rebound.dto.CounselorDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CounselorMapper {
    public List<CounselorDTO> getCounselors();
    //    상담사 추가
    public void insertCounselor(CounselorDTO counselorDTO);


    //    이메일 중복 검사
    @Select("select count(*) > 0 from tbl_counselor where counselor_email = #{counselorEmail}")
    public boolean existCounselorEmail(String counselorEmail);
    //    전화번호 중복 검사
    @Select("select count(*)>0 from app.tbl_counselor where counselor_phone_number=#{counselorPhoneNumber}")
    public boolean existCounselorPhoneNumber(String counselorPhoneNumber);
}
