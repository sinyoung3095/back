package com.example.rebound.repository;

import com.example.rebound.dto.InquiryDTO;
import com.example.rebound.mapper.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InquiryDAO {
    private final InquiryMapper inquiryMapper;

    public void saveInquiry(InquiryDTO inquiryDTO) {
        inquiryMapper.insertInquiry(inquiryDTO);
    }
}
