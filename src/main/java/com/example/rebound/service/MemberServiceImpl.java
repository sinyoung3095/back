package com.example.rebound.service;

import com.example.rebound.dto.*;
import com.example.rebound.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final PaymentDAO paymentDAO;
    private final FileDAO fileDAO;
    private final MemberProfileFileDAO memberProfileFileDAO;
    private final FileService fileService;

    @Override
    public void joinMember(MemberDTO memberDTO) {
        memberDAO.save(memberDTO);
    }

    @Override
    public boolean isExistMemberEmail(String memberEmail) {
        return memberDAO.isExistMemberEmail(memberEmail);
    }

    @Override
    public boolean isExistMemberPhoneNumber(String memberPhoneNumber) {
        return memberDAO.isExistMemberPhoneNumber(memberPhoneNumber);
    }

    @Override
    public Optional<MemberDTO> login(MemberDTO memberDTO) {
        return memberDAO.findMemberByEmailAndPassword(memberDTO);
    }

    @Override
    public Optional<MemberDTO> findMemberByKakaoEmail(String kakaoEmail) {
        return memberDAO.findMemberByKakaoEmail(kakaoEmail);
    }

    @Override
    public void joinKakaoMember(MemberDTO memberDTO) {
        memberDAO.saveKakaoMember(memberDTO); // insert
        Long memberId = memberDAO.findMemberByKakaoEmail(memberDTO.getKakaoEmail()).get().getId();
        memberDTO.setId(memberId);
    }

    @Override
    public void saveKakaoProfile(MemberDTO memberDTO) {
        String todayPath = getPath();
        String rootPath = "C:/reboundFile/" + todayPath;

        try {
            File directory = new File(rootPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String imageUrl = memberDTO.getKakaoProfileUrl();
            String fileName = UUID.randomUUID().toString() + ".jpg";

            File fileToSave = new File(rootPath, fileName);

            try (InputStream in = new URL(imageUrl).openStream()) {
                Files.copy(in, fileToSave.toPath());
            }

            String fileSize = String.valueOf(fileToSave.length());

            FileDTO fileDTO = new FileDTO();
            fileDTO.setFileName(fileName);
            fileDTO.setFileOriginalName("kakao_profile.jpg");
            fileDTO.setFileContentType("image/jpeg");
            fileDTO.setFilePath(todayPath);
            fileDTO.setFileSize(fileSize);

            fileDAO.uploadFile(fileDTO);
            System.out.println("파일 저장 후 ID: " + fileDTO.getId());

            MemberProfileFileDTO mpf = new MemberProfileFileDTO();
            mpf.setMemberId(memberDTO.getId());
            mpf.setId(fileDTO.getId());

            memberProfileFileDAO.saveMemberProfileFile(mpf);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<MemberDTO> showFileById(Long memberId) {
        Optional<MemberDTO> memberOpt = memberDAO.selectMemberById(memberId);
        Optional<FileDTO> fileOpt = fileDAO.findFileByMemberId(memberId);

        if (memberOpt.isPresent()) {
            MemberDTO member = memberOpt.get();
            fileOpt.ifPresent(member::setFile);
            return Optional.of(member);
        }

        return Optional.empty();
    }

    @Override
    public void memberRename(MemberDTO memberDTO) {
        memberDAO.memberRename(memberDTO);
    }

    @Override
    public void deleteProfile(Long id){
        memberProfileFileDAO.deleteMemberProfileById(id);
        fileDAO.deleteFile(id);
        Optional<FileDTO> deleteFile=memberProfileFileDAO.findMemberProfileFileById(id);
        String deleteFilePath=deleteFile.get().getFilePath();
        String deleteFileName=deleteFile.get().getFileName();
        File file = new File("C:/file/" + deleteFilePath, deleteFileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public void updateMemberPassword(String memberPassword, String memberEmail) {
        memberDAO.updateMemberPassword(memberPassword, memberEmail);
    }

    @Override
    public MemberDTO findEmailByPhone(String memberPhoneNumber) {
        return memberDAO.selectEmailByPhonerNumber(memberPhoneNumber);
    }

}
