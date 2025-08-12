package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class NoticeDTO {
    private Long id;
    private String noticeTitle;
    private String noticeContent;
    private String createdDate;
    private String updatedDate;
}
