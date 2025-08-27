package com.example.rebound.repository;

import com.example.rebound.domain.InquiryFileVO;
import com.example.rebound.dto.InquiryFileDTO;
import com.example.rebound.mapper.InquiryFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InquiryFileDAO {
    private final InquiryFileMapper inquiryFileMapper;

    public void save(InquiryFileDTO inquiryFileDTO) {
        inquiryFileMapper.insertInquiryFile(inquiryFileDTO);
    }
}
