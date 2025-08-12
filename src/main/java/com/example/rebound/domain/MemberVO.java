package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class MemberVO extends Period {
    private String id;
    private String memberName;
    private String memberEmail;
    private String kakaoEmail;
    private String memberProvider;
    private Long memberPhoneNumber;
    private String memberPassword;
    private int memberSuggestionCount;
    private String kakaoProfileUrl;
    private String mentor;
    private String memberStatus;
    private String memberCommon;
}
