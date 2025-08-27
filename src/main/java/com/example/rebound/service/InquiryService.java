package com.example.rebound.service;

import com.example.rebound.domain.FileVO;
import com.example.rebound.domain.InquiryFileVO;
import com.example.rebound.domain.InquiryVO;
import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.InquiryDTO;
import com.example.rebound.dto.InquiryFileDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


public interface InquiryService {
    public void writeInquiry(InquiryDTO inquiryDTO, List<MultipartFile> files);

default String getPath(){
    return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
}
default InquiryVO toVO(InquiryDTO inquiryDTO){
    return InquiryVO.builder()
            .inquiryTitle(inquiryDTO.getInquiryTitle())
            .inquiryContent(inquiryDTO.getInquiryContent())
            .inquiryEmail(inquiryDTO.getInquiryEmail())
            .memberId(inquiryDTO.getMemberId())
            .build();
}
default FileVO toVO(FileDTO fileDTO){
    FileVO fileVO = FileVO.builder()
            .fileContentType(fileDTO.getFileContentType())
            .fileName(fileDTO.getFileName())
            .fileSize(fileDTO.getFileSize())
            .fileOriginalName(fileDTO.getFileOriginalName())
            .filePath(fileDTO.getFilePath())
            .build();
    return fileVO;
}
default InquiryFileVO toVO(InquiryFileDTO inquiryFileDTO){
    InquiryFileVO inquiryFileVO = InquiryFileVO.builder()
            .id(inquiryFileDTO.getId())
            .inquiryId(inquiryFileDTO.getInquiryId()).build();
    return inquiryFileVO;
}
}