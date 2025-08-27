package com.example.rebound.mapper;

import com.example.rebound.dto.NoticeDTO;
import com.example.rebound.util.MemberCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {

    public List<NoticeDTO> selectNoticeAll(@Param("memberCriteria") MemberCriteria memberCriteria, @Param("keyword") String keyword);
    public int selectNoticeAllCount(String keyword);
    public NoticeDTO selectNoticeById(int id);
}
