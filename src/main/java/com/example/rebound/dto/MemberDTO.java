package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MemberDTO {
    private String id;
    private String memberName;
    private String memberEmail;
    private String kakaoEmail;
    private String memberProvider;
    private String memberPhoneNumber;
    private String memberPassword;
    private int memberSuggestionCount;
    private String kakaoProfileUrl;
    private String mentor;
    private String memberStatus;
    private String memberCommon;
    private String createdDate;
    private String updatedDate;
    private boolean remember;
}
