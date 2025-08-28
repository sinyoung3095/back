package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CounselorDTO {
    private Long id;
    private String counselorName;
    private String counselorEmail;
    private String counselorPhoneNumber;
    private String counselorPassword;
    private String counselorAddress;
    private String counselorStatus;
    private String counselorApprovalStatus;
    private String createdDate;
    private String updatedDate;
    private List<FileDTO> counselorQualificationsFiles;
    private String counselorLicenseName;
    private MultipartFile file;
    private FileDTO fileInfo;
}
