package com.example.rebound.mapper;

import com.example.rebound.dto.NoticeDTO;
import com.example.rebound.util.MemberCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    public List<NoticeDTO> selectNoticeAll(MemberCriteria memberCriteria);
    public int selectNoticeAllCount();
    public NoticeDTO selectNoticeById(int id);
}
