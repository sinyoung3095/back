package com.example.rebound.mapper;

import com.example.rebound.domain.FileVO;
import com.example.rebound.domain.NoticeFileVO;
import com.example.rebound.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface NoticeFileMapper {
//    추가
    public void insertNoticeFile(NoticeFileVO noticeFileVO);
}
