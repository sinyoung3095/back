package com.example.rebound.service;

import com.example.rebound.domain.InquiryVO;
import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.InquiryDTO;
import com.example.rebound.dto.InquiryFileDTO;
import com.example.rebound.repository.FileDAO;
import com.example.rebound.repository.InquiryDAO;
import com.example.rebound.repository.InquiryFileDAO;
import com.example.rebound.repository.MemberDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InquiryServiceImpl implements InquiryService {
    private final InquiryDAO inquiryDAO;
    private final MemberDAO memberDAO;
    private final FileDAO fileDAO;
    private final InquiryFileDAO inquiryFileDAO;

    @Override
    public void writeInquiry(InquiryDTO inquiryDTO, List<MultipartFile> files) {
        String todayPath = getPath();
        String rootPath = "C:/upload/"+todayPath;
        boolean emailCheck = memberDAO.isExistMemberEmail(String.valueOf(inquiryDTO.getMemberEmail()));
        boolean phoneCheck = memberDAO.isExistMemberPhoneNumber(String.valueOf(inquiryDTO.getMemberPhoneNumber()));
        inquiryDTO.setMemberId(memberDAO.findMemberByEmail(inquiryDTO.getMemberEmail()).getId());
        if (emailCheck && phoneCheck) {
            inquiryDAO.saveInquiry(inquiryDTO);
            files.forEach(file -> {
                if(file.getOriginalFilename().equals("")){
                    return ;
                }
                UUID  uuid = UUID.randomUUID();
                FileDTO fileDTO = new FileDTO();
                InquiryFileDTO inquiryFileDTO = new InquiryFileDTO();

                fileDTO.setFileName(uuid.toString() + "_" + file.getOriginalFilename());
                fileDTO.setFileOriginalName(file.getOriginalFilename());
                fileDTO.setFilePath(todayPath);
                fileDTO.setFileSize(String.valueOf(file.getSize()));
                fileDTO.setFileContentType(file.getContentType());

                fileDAO.uploadFile(fileDTO);

                inquiryFileDTO.setInquiryId(inquiryDTO.getId());
                inquiryFileDTO.setId(fileDTO.getId());

                inquiryFileDAO.save(inquiryFileDTO);
                File directory = new File(rootPath);
                if(!directory.exists()){
                    directory.mkdirs();
                }

                try {
//                원본 업로드
                    file.transferTo(new File(rootPath, uuid.toString() + "_" + file.getOriginalFilename()));

//                썸네일 업로드
                    if(file.getContentType().startsWith("image")) {
//                    UUID tUuid = new UUID(); // 원본 이미지의 UUID와 다르게 설정
                        FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid.toString() + "_" + file.getOriginalFilename()));
                        Thumbnailator.createThumbnail(file.getInputStream(), out, 100, 100);
                        out.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        }
    }
}
