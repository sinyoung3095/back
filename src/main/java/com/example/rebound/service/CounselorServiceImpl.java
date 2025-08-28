package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.CounselorQualificationsFileDTO;
import com.example.rebound.dto.FileDTO;
import com.example.rebound.repository.CounselorDAO;
import com.example.rebound.repository.CounselorQualificationsFileDAO;
import com.example.rebound.repository.FileDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class CounselorServiceImpl implements CounselorService {
    final CounselorDAO counselorDAO;
    private final FileDAO fileDAO;
    private final CounselorQualificationsFileDAO counselorQualificationsFileDAO;

    @Override
    public void joinCounselor(CounselorDTO counselorDTO, List<MultipartFile> files) {
        String todayPath=getPath();
        String rootPath="C:/reboundFile/"+todayPath;

        counselorDAO.saveCounselor(counselorDTO);

        files.forEach(file -> {
            if(file.getOriginalFilename().equals("")){
                return;
            }
            log.info(rootPath);
            UUID uuid = UUID.randomUUID();
            FileDTO fileDTO=new FileDTO();
            CounselorQualificationsFileDTO counselorQualificationsFileDTO=new CounselorQualificationsFileDTO();

            fileDTO.setFileName(uuid.toString()+"_"+file.getOriginalFilename());
            fileDTO.setFileOriginalName(file.getOriginalFilename());
            fileDTO.setFileContentType(file.getContentType());
            fileDTO.setFilePath(todayPath);
            fileDTO.setFileSize(String.valueOf(file.getSize()));
            fileDAO.uploadFile(fileDTO);

//            System.out.println(fileDTO.getId()); => null로 나옴

            counselorQualificationsFileDTO.setCounselorId(counselorDTO.getId());
            counselorQualificationsFileDTO.setId(fileDTO.getId());
            counselorQualificationsFileDAO.saveCounselorQualificationsFile(counselorQualificationsFileDTO);

            File directory=new File(rootPath);
            if(!directory.exists()){
                directory.mkdirs();
            }

            try {
                file.transferTo(new File(rootPath, uuid.toString()+"_"+file.getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public boolean isExistCounselorEmail(String counselorEmail) {
        return counselorDAO.isExistCounselorEmail(counselorEmail);
    }

    @Override
    public boolean isExistCounselorPhoneNumber(String counselorPhoneNumber) {
        return counselorDAO.isExistCounselorPhoneNumber(counselorPhoneNumber);
    }

    @Override
    public Optional<CounselorDTO> login(CounselorDTO counselorDTO) {
        return counselorDAO.findCounselorByEmailAndPassword(counselorDTO);
    }

    @Override
    public Optional<CounselorDTO> showFileById(Long counselorId) {
        Optional<CounselorDTO> counselorOpt = counselorDAO.selectCounselorById(counselorId);
        Optional<FileDTO> fileOpt = fileDAO.findFileByCounselorId(counselorId);

        if (counselorOpt.isPresent()) {
            CounselorDTO counselor = counselorOpt.get();
            fileOpt.ifPresent(counselor::setFileInfo);
            return Optional.of(counselor);
        }

        return Optional.empty();
    }

    @Override
    public void counselorRename(CounselorDTO counselorDTO) {
        counselorDAO.counselorRename(counselorDTO);
    }
//    커밋 테스트
}
