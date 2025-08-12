package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class NoticeFileDTO {
    private Long id;
    private Long noticeId;
}
