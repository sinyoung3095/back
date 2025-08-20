package com.example.rebound.repository;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;
//    추가
    public void uploadFile(FileDTO fileDTO) {fileMapper.insertFile(fileDTO);}
}
