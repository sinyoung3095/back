package com.example.rebound.repository;

import com.example.rebound.domain.NoticeFileVO;
import com.example.rebound.mapper.NoticeFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
@RequiredArgsConstructor
public class NoticeFileDAO {
    private final NoticeFileMapper noticeFileMapper;

    public void saveNoticeFile(NoticeFileVO noticeFileVO) {
        noticeFileMapper.insertNoticeFile(noticeFileVO);
    }

}
