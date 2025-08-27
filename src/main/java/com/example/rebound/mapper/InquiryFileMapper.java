package com.example.rebound.mapper;

import com.example.rebound.domain.InquiryFileVO;
import com.example.rebound.dto.InquiryDTO;
import com.example.rebound.dto.InquiryFileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryFileMapper {
    public void insertInquiryFile(InquiryFileDTO inquiryFileDTO);
}
