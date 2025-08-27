package com.example.rebound.repository;

import com.example.rebound.dto.NoticeDTO;
import com.example.rebound.mapper.MemberMapper;
import com.example.rebound.mapper.NoticeMapper;
import com.example.rebound.util.MemberCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeDAO {
    private final NoticeMapper noticeMapper;
    public List<NoticeDTO> findNoticeAll(MemberCriteria memberCriteria,String keyword) {
        return noticeMapper.selectNoticeAll(memberCriteria,keyword);
    }
    public int findNoticeCount(String keyword) {
        return noticeMapper.selectNoticeAllCount(keyword);
    }
    public NoticeDTO findNoticeById(int id) {
        return noticeMapper.selectNoticeById(id);
    }
}
