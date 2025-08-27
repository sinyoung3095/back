package com.example.rebound.mapper;

import com.example.rebound.domain.InquiryVO;
import com.example.rebound.dto.InquiryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryMapper {
    public void insertInquiry(InquiryDTO inquiryDTO);
}
