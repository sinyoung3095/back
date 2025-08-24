package com.example.rebound.mapper;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.util.MemberCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

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

//    로그인
    public Optional<CounselorDTO> selectCounselor(CounselorDTO counselorDTO);

//    상담사 통합검색
    public List<CounselorDTO> selectCounselorAll(@Param("memberCriteria") MemberCriteria memberCriteria, @Param("keyword") String keyword);
//    상담사 수 통합검색
    public int selectCounselorAllCount(String keyword);
}
