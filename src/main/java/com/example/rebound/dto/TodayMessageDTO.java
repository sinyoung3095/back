package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class TodayMessageDTO {
    private Long id;
    private String todayMessageContent;
    private Long counselorId;
    private String createdDate;
    private String updatedDate;
}
