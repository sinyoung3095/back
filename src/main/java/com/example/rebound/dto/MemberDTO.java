package com.example.rebound.dto;

import com.example.rebound.common.enumeration.Provider;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MemberDTO {
    private Long id;
    private String memberName;
    private String memberEmail;
    private String kakaoEmail;
    private Provider memberProvider;
    private String memberPhoneNumber;
    private String memberPassword;
    private int memberSuggestionCount;
    private String kakaoProfileUrl;
    private String mentor;
    private String memberStatus;
    private String memberCommon;
    private String createdDate;
    private String updatedDate;
    private String latelyDate;
    private boolean remember;
    private Optional<FileDTO> file;
}
