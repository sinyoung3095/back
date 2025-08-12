package com.example.rebound.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of = "id")
public class NoticeFileVO{
    private Long id;
    private Long noticeId;
}
