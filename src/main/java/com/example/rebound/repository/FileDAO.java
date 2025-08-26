package com.example.rebound.repository;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;
//    추가
    public void uploadFile(FileDTO fileDTO) {fileMapper.insertFile(fileDTO);}
//    조회
    public Optional<FileDTO> findFileById(Long id) {return fileMapper.selectFileById(id);}
    public Optional<FileDTO> findFileByMemberId(Long memberId) {return fileMapper.selectFileByMemberId(memberId);}
//    삭제
    public void deleteFile(Long id){
        fileMapper.deleteFileById(id);
    }
}
