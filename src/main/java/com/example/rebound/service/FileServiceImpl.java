package com.example.rebound.service;

import com.example.rebound.dto.FileDTO;
import com.example.rebound.repository.FileDAO;
import com.example.rebound.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class FileServiceImpl implements FileService {
    private final FileDAO fileDAO;
    @Override
    public void uploadFile(FileDTO fileDTO) {
        fileDAO.uploadFile(fileDTO);
    }

    @Override
    public Optional<FileDTO> findFileById(Long id) {
        return fileDAO.findFileById(id);
    }

    @Override
    public Optional<FileDTO> findFileByMemberId(Long memberId) {
        return fileDAO.findFileByMemberId(memberId);
    }
}
