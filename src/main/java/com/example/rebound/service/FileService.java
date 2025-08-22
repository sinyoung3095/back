package com.example.rebound.service;


import com.example.rebound.dto.FileDTO;

import java.util.Optional;

public interface FileService {
//    파일 업로드
    public void uploadFile(FileDTO fileDTO);
//    파일 조회
    public Optional<FileDTO> findFileById(Long id);
}
